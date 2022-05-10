package Stack;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class MULinkedStack<E> implements StackInterface<E> {

	private Node<E> topOfStack = null;

	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data) {
			this.data = data;
			next = null;
		}

		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
	}

	// Lab 5 Exercise 1.3
	public MULinkedStack() {
		
	}
	
	public MULinkedStack(E[] data) {
		for (int i = 0; i < data.length; i++) {
			push(data[i]);
		}
	}

	@Override
	public E push(E obj) {
		topOfStack = new Node<>(obj, topOfStack);
		return obj;

	}

	@Override
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return topOfStack.data;
		}
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			E result = topOfStack.data;
			topOfStack = topOfStack.next;
			return result;
		}
	}

	@Override
	public boolean isEmpty() {
		return topOfStack == null;
	}

	@Override
	public String toString() {
		StringJoiner result = new StringJoiner("\n");
		Node<E> node = topOfStack;
		while (node != null) {
			result.add(node.data.toString());
			node = node.next;
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Integer[] data = {1,4,5,7};
		MULinkedStack<Integer> stack = new MULinkedStack<>(data);
		System.out.println(stack);
	}

}
