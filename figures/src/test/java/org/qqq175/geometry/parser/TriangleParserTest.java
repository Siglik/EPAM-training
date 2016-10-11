package org.qqq175.geometry.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.qqq175.geometry.figure.Triangle;

public class TriangleParserTest {
	static final String BAD_PATH = "..";
	static final String TESTFILE_DIR = "test";
	static final String TESTFILE_NAME = "testfile.dat";
	static final String GOOD_DATA = "1 1 2 0 7 .5";
	static final String BAD_DATA = "1 r 4 5 6 8";
	TriangleParser parser;

	@Before
	public void setUp() throws Exception {
		parser = new TriangleParser();
		createFile();
	}

	@After
	public void tearDown() throws Exception {
		deleteFile();
		parser = null;
	}

	@Test(expected = RuntimeException.class)
	public void parseTestWrongPath() {
		parser.parse(BAD_PATH);
	}

	@Test
	public void parseTestGoodData() throws IOException {
		writeDataToFile(GOOD_DATA);
		List<Triangle> traingles = parser.parse(TESTFILE_DIR + "/" + TESTFILE_NAME);

		Assert.assertEquals(traingles.size(), 1);
		Triangle triangle = traingles.get(0);
		Assert.assertEquals(triangle.getA().getX(), 1.0, 1e-10);
		Assert.assertEquals(triangle.getA().getY(), 1.0, 1e-10);

		Assert.assertEquals(triangle.getB().getX(), 2.0, 1e-10);
		Assert.assertEquals(triangle.getB().getY(), 0.0, 1e-10);

		Assert.assertEquals(triangle.getC().getX(), 7.0, 1e-10);
		Assert.assertEquals(triangle.getC().getY(), 0.5, 1e-10);

	}

	@Test
	public void parseTestBadData() throws IOException {
		writeDataToFile(BAD_DATA);
		List<Triangle> traingles = parser.parse(TESTFILE_DIR + "/" + TESTFILE_NAME);

		Assert.assertEquals(traingles.size(), 0);
	}

	@Test
	public void parseTestMixedData() throws IOException {
		writeDataToFile(GOOD_DATA);
		writeDataToFile(BAD_DATA);
		writeDataToFile(GOOD_DATA);
		writeDataToFile(BAD_DATA);
		List<Triangle> traingles = parser.parse(TESTFILE_DIR + "/" + TESTFILE_NAME);

		Assert.assertEquals(traingles.size(), 2);

		Triangle triangle = traingles.get(0);
		Assert.assertEquals(triangle.getA().getX(), 1.0, 1e-10);
		Assert.assertEquals(triangle.getA().getY(), 1.0, 1e-10);

		Assert.assertEquals(triangle.getB().getX(), 2.0, 1e-10);
		Assert.assertEquals(triangle.getB().getY(), 0.0, 1e-10);

		Assert.assertEquals(triangle.getC().getX(), 7.0, 1e-10);
		Assert.assertEquals(triangle.getC().getY(), 0.5, 1e-10);

		triangle = traingles.get(1);
		Assert.assertEquals(triangle.getA().getX(), 1.0, 1e-10);
		Assert.assertEquals(triangle.getA().getY(), 1.0, 1e-10);

		Assert.assertEquals(triangle.getB().getX(), 2.0, 1e-10);
		Assert.assertEquals(triangle.getB().getY(), 0.0, 1e-10);

		Assert.assertEquals(triangle.getC().getX(), 7.0, 1e-10);
		Assert.assertEquals(triangle.getC().getY(), 0.5, 1e-10);
	}

	private void createFile() throws IOException {
		File dir = new File(TESTFILE_DIR);
		dir.mkdir();
		File file = new File(TESTFILE_DIR + "/" + TESTFILE_NAME);
		file.createNewFile();
	}

	private void deleteFile() throws IOException {
		File file = new File(TESTFILE_DIR + "/" + TESTFILE_NAME);
		file.delete();
		File dir = new File(TESTFILE_DIR);
		dir.delete();
	}

	private void writeDataToFile(String data) throws IOException {
		try (FileWriter fw = new FileWriter(TESTFILE_DIR + "/" + TESTFILE_NAME, true)) {
			try (BufferedWriter bw = new BufferedWriter(fw)) {
				try (PrintWriter out = new PrintWriter(bw)) {
					out.println(data);
				}
			}
		}
	}
}
