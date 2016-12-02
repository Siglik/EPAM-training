package org.qqq175.textparser.composite;

import org.qqq175.textparser.composite.text.TextComponent;

public class ComponentOrderWrapper implements Comparable<ComponentOrderWrapper> {
	private TextComponent item;
	private int order;

	/**
	 * @param item
	 * @param priority
	 */
	public ComponentOrderWrapper(TextComponent item, int order) {
		this.item = item;
		this.order = order;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ComponentOrderWrapper other) {
		return this.getOrder() - other.getOrder();
	}

	/**
	 * @return the node
	 */
	public TextComponent getItem() {
		return item;
	}

	/**
	 * @return the priority
	 */
	public int getOrder() {
		return order;
	}
}
