package org.qqq175.textparser.visitor;

public interface Visitor<R> {
	R result();

	void reset();
}
