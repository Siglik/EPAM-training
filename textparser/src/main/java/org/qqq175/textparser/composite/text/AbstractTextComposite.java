package org.qqq175.textparser.composite.text;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class AbstractTextComposite<T extends TextComponent> extends TextComponent {
	List<T> children;

	public AbstractTextComposite() {
		children = new ArrayList<>();
	}

	public AbstractTextComposite(List<T> children) {
		this.children = children;
	}

	public int childrenCount() {
		return 0;
	}

	public T getChild(int index) {
		return children.get(index);
	}

	public Stream<T> getChildrenAsSteam() {
		return children.stream();
	}

	public List<T> getChildrenList() {
		return children;
	}

	public void add(T component) {
		children.add(component);
	}

	public void replaceChild(int index, T component) {
		children.set(index, component);
	}

	public boolean remove(T component) {
		return children.remove(component);
	}
}
