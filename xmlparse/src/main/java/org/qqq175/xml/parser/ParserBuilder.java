/**
 * 
 */
package org.qqq175.xml.parser;

import org.qqq175.xml.exception.UnableBuildParserException;

/**
 * @author qqq175
 *
 */
public abstract class ParserBuilder {
	private FlowerParser parser;
	private String path;

	/**
	 * return builded parser
	 * 
	 * @return
	 */
	public FlowerParser getParser() {
		return parser;
	}

	/**
	 * set XML filepath
	 * 
	 * @param path
	 */
	protected void setPath(String path) {
		this.path = path;
	}

	/**
	 * builds concrete parser
	 * 
	 * @throws UnableBuildParserException
	 */
	protected abstract void buildParser() throws UnableBuildParserException;

	/**
	 * @return the path
	 */
	protected String getPath() {
		return path;
	}

	/**
	 * @param parser
	 *            the parser to set
	 */
	protected void setParser(FlowerParser parser) {
		this.parser = parser;
	}
}
