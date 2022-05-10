package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class MUArrayStack<E> implements StackInterface<E> {

	private List<E> theData;

	public MUArrayStack() {
		theData = new ArrayList<>();
	}

	@Override
	public E push(E obj) {
		theData.add(obj);
		return obj;
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return theData.get(theData.size() - 1);
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return theData.remove(theData.size() - 1);
	}

	@Override
	public boolean isEmpty() {
		return theData.isEmpty();
	}

	// lab 5 exercise 1.1
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = theData.size() - 1; i >= 0; i--) {
			result.append(theData.get(i));
			result.append("\n");
		}
		return result.toString();
	}
	
	public static void main(String[]args) {
		MUArrayStack<Integer> stack = new MUArrayStack<>();
		stack.push(3);
		stack.push(4);
		stack.push(6);
		System.out.println(stack);
	}

}
