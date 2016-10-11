package org.qqq175.geometry;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.qqq175.geometry.action.GeometryActionTest;
import org.qqq175.geometry.creator.TriangleCreatorTest;
import org.qqq175.geometry.parser.TriangleParserTest;

@RunWith(Suite.class)
@SuiteClasses({ TriangleCreatorTest.class, GeometryActionTest.class, TriangleParserTest.class })
public class AllTestsSuite {

}
