/**
 * 
 */
package org.qqq175.xml.parser;

/**
 * @author qqq175
 *
 */
public class StAXBuilder extends ParserBuilder {

	@Override
	protected void buildParser() {
		this.setParser(new StAXParser(this.getPath()));
	}

}
