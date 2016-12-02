package org.qqq175.textparser.visitor;

import java.util.Stack;

import org.qqq175.textparser.composite.expression.AddComposite;
import org.qqq175.textparser.composite.expression.DecrementComposite;
import org.qqq175.textparser.composite.expression.DivideComposite;
import org.qqq175.textparser.composite.expression.ExpressionLeaf;
import org.qqq175.textparser.composite.expression.IncrementComposite;
import org.qqq175.textparser.composite.expression.MultiplyComposite;
import org.qqq175.textparser.composite.expression.NegateComposite;
import org.qqq175.textparser.composite.expression.SubstractComposite;

public class EvalExpressionVisitor implements ExpressionVisitor {
	/**
	 * Stack containing the integral total of the expression tree that's being
	 * visited.
	 */
	private Stack<Integer> stack = new Stack<Integer>();

	@Override
	public void visit(ExpressionLeaf component) {
		stack.push(component.item());
	}

	@Override
	public void visit(IncrementComposite component) {
		component.right().accept(this);
		stack.push(stack.pop() + 1);
	}

	@Override
	public void visit(DecrementComposite component) {
		component.right().accept(this);
		stack.push(stack.pop() - 1);
	}

	@Override
	public void visit(NegateComposite component) {
		component.right().accept(this);
		stack.push(-stack.pop());
	}

	@Override
	public void visit(AddComposite component) {
		component.left().accept(this);
		component.right().accept(this);
		stack.push(stack.pop() + stack.pop());
	}

	@Override
	public void visit(SubstractComposite component) {
		component.left().accept(this);
		component.right().accept(this);
		int right = stack.pop();
		int left = stack.pop();
		stack.push(left - right);
	}

	@Override
	public void visit(MultiplyComposite component) {
		component.left().accept(this);
		component.right().accept(this);
		stack.push(stack.pop() * stack.pop());
	}

	@Override
	public void visit(DivideComposite component) {
		component.left().accept(this);
		component.right().accept(this);
		int right = stack.pop();
		int left = stack.pop();
		stack.push(left / right);
	}

	/** Print the total of the evaluation. */
	@Override
	public String result() {
		if (!stack.isEmpty())
			return Integer.toString(stack.peek());
		else
			return "0";
	}

	/** Resets the evaluation to it can be reused. */
	@Override
	public void reset() {
		stack.clear();
	}
}
