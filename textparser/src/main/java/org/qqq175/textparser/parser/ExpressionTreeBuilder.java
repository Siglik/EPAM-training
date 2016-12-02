package org.qqq175.textparser.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.qqq175.textparser.composite.expression.AddComposite;
import org.qqq175.textparser.composite.expression.DecrementComposite;
import org.qqq175.textparser.composite.expression.DivideComposite;
import org.qqq175.textparser.composite.expression.ExpressionComponent;
import org.qqq175.textparser.composite.expression.ExpressionLeaf;
import org.qqq175.textparser.composite.expression.IncrementComposite;
import org.qqq175.textparser.composite.expression.MultiplyComposite;
import org.qqq175.textparser.composite.expression.NegateComposite;
import org.qqq175.textparser.composite.expression.SubstractComposite;

public class ExpressionTreeBuilder {

	/** The precedence of the '+' and '-' operators. */
	final static int addSubPrecedence = 1;

	/** The precedence of the '*' and '/' operators. */
	final static int mulDivPrecedence = 2;

	/** The precedence of a '-' operator. */
	final static int incDecNegatePrecedence = 3;

	/** The precedence of a number. */
	final static int numberPrecedence = 4;

	/** The precedence of a parenthesis. */
	final static int parenPrecedence = 5;

	final static String POSTINCREMENT_REGEX = "(\\d+)\\+\\+";
	final static String POSTDECREMENT = "(\\d+)--";

	public ExpressionComponent build(String expression) {
		String prepared = prepareParse(expression);
		return makeTree(prepared);
	}

	private ExpressionComponent makeTree(String expression) {
		int nextIndex = nextElement(expression);
		String curNumber = "";
		while (nextIndex < expression.length() && Character.isDigit(expression.charAt(nextIndex))) {
			curNumber += expression.charAt(nextIndex);
			nextIndex++;
		}
		if (!curNumber.isEmpty()) {
			return new ExpressionLeaf(curNumber);
		} else {
			switch (expression.charAt(nextIndex)) {
			case '+':
				if (expression.charAt(nextIndex + 1) != '+') {
					return new AddComposite(makeTree(expression.substring(0, nextIndex)), makeTree(expression.substring(nextIndex + 1)));
				} else {
					return new IncrementComposite(makeTree(expression.substring(nextIndex + 2)));
				}
			case '-':
				if (expression.charAt(nextIndex + 1) != '-') {
					if (nextIndex != 0 && (Character.isDigit(expression.charAt(nextIndex - 1)) || expression.charAt(nextIndex - 1) == ')')) {
						return new SubstractComposite(makeTree(expression.substring(0, nextIndex)), makeTree(expression.substring(nextIndex + 1)));
					} else {
						return new NegateComposite(makeTree(expression.substring(nextIndex + 1)));
					}
				} else {
					return new DecrementComposite(makeTree(expression.substring(nextIndex + 2)));
				}
			case '*':
				return new MultiplyComposite(makeTree(expression.substring(0, nextIndex)), makeTree(expression.substring(nextIndex + 1)));
			case '/':
				return new DivideComposite(makeTree(expression.substring(0, nextIndex)), makeTree(expression.substring(nextIndex + 1)));
			default:
				throw new RuntimeException();
			}
		}
	}

	private int nextElement(String expression) {
		int accumulatedPrecedence = 0;
		int minPrecedence = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < expression.length(); i++) {
			int currentPrecedence = accumulatedPrecedence;
			int numberStart = -1;

			while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
				currentPrecedence = accumulatedPrecedence + numberPrecedence;
				if (numberStart == -1) {
					numberStart = i;
				}
				i++;
			}
			if (numberStart != -1) {
				i--;
				if (minPrecedence >= currentPrecedence) {
					minPrecedence = currentPrecedence;
					index = numberStart;
				}
			} else {
				switch (expression.charAt(i)) {
				case '+':
				case '-':
					if (expression.charAt(i + 1) != expression.charAt(i)) {
						if (i != 0 && (Character.isDigit(expression.charAt(i - 1)) || expression.charAt(i - 1) == ')')) {
							currentPrecedence = accumulatedPrecedence + addSubPrecedence;
						} else {
							currentPrecedence = accumulatedPrecedence + incDecNegatePrecedence;
						}
						if (minPrecedence >= currentPrecedence) {
							minPrecedence = currentPrecedence;
							index = i;
						}
						break;
					} else {
						currentPrecedence = accumulatedPrecedence + incDecNegatePrecedence;
						if (minPrecedence >= currentPrecedence) {
							minPrecedence = currentPrecedence;
							index = i;
						}
						// increment to go to next element because increment or
						// decrement contains 2 chars
						i++;
						break;
					}
				case '*':
				case '/':
					currentPrecedence = accumulatedPrecedence + mulDivPrecedence;
					if (minPrecedence >= currentPrecedence) {
						minPrecedence = currentPrecedence;
						index = i;
					}
					break;
				case '(':
					accumulatedPrecedence += parenPrecedence;
					break;
				case ')':
					accumulatedPrecedence -= parenPrecedence;
					break;
				default:
					break;
				}
			}
		}
		return index;
	}

	public String prepareParse(String expression) {
		// convert from unary operations from postfix to prefix form
		Pattern pattern = Pattern.compile(POSTINCREMENT_REGEX);
		Matcher matcher = pattern.matcher(expression);
		String result = expression;

		while (matcher.find()) {
			String replacement = "++" + matcher.group(1);
			result = result.replace(matcher.group(), replacement);
		}

		matcher.reset();
		matcher.usePattern(Pattern.compile(POSTDECREMENT));

		while (matcher.find()) {
			String replacement = "--" + matcher.group(1);
			result = result.replace(matcher.group(), replacement);
		}

		/* replace whitespaces */
		result = result.replaceAll("\\s+", "");
		return result;
	}
}