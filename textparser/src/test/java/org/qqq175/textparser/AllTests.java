package org.qqq175.textparser;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.qqq175.textparser.parser.ParagraphParseHandlerTest;
import org.qqq175.textparser.parser.SentenceParseHandlerTest;
import org.qqq175.textparser.parser.TextParseHandlerTest;

@RunWith(Suite.class)
@SuiteClasses({ ParagraphParseHandlerTest.class, TextParseHandlerTest.class, SentenceParseHandlerTest.class })
public class AllTests {

}
