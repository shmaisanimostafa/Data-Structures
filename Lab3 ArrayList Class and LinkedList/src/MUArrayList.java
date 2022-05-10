package ArrayList;

import java.util.Arrays;

/**
 * This class implements some of the methods of the Java ArrayList class
 */
public class MUArrayList<E> {
	// Data fields
	/** The default initial capacity */
	private static final int INITIAL_CAPACITY = 10;
	/** The underlying data array */
	private E[] theData;
	/** The current size */
	private int size = 0;
	/** The current capacity */
	private int capacity = 0;

	@SuppressWarnings("unchecked")
	public MUArrayList() {
		capacity = INITIAL_CAPACITY;
		theData = (E[]) new Object[capacity];
	}
	
	@SuppressWarnings("unchecked")
	public MUArrayList(int capacity) {
		this.capacity = capacity;
		theData = (E[]) new Object[capacity];
	}

	public boolean add(E anEntry) {
		if (size == capacity) {
			reallocate();
		}
		theData[size] = anEntry;
		size++;
		return true;
	}

	public void add(int index, E anEntry) {
		// check bounds
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		// Make sure there is room
		if (size >= capacity) {
			reallocate();
		}
		// shift data
		for (int i = size; i > index; i--) {
			theData[i] = theData[i - 1];
		}
		// insert item
		theData[index] = anEntry;
		size++;
	}

	public E set(int index, E newValue) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E oldValue = theData[index];
		theData[index] = newValue;
		return oldValue;
	}

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return theData[index];
	}

	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E returnValue = theData[index];
		for (int i = index + 1; i < size; i++) {
			theData[i - 1] = theData[i];
		}
		size--;
		return returnValue;
	}

	private void reallocate() {
		capacity *= 2;
		theData = Arrays.copyOf(theData, capacity);
	}

	// lab 2 exercise: Question 1, part 1
	public int indexOf(E item) {
		for (int i = 0; i < size; i++) {
			if (item.equals(theData[i]))
				return i;
		}
		return -1;
	}

	// lab 2 exercise: Question 1, part 2
	public boolean addMiddle(E item) {
		if (size == capacity) {
			reallocate();
		}
		// shift data
		for (int i = size; i > size / 2; i--) {
			theData[i] = theData[i - 1];
		}
		// insert item
		theData[size / 2] = item;
		size++;
		return true;
	}

	@Override
	public String toString() {
		String result = "[ ";
		for (int i = 0; i < size; i++) {
			result += theData[i] + " ";
		}
		result += "]";
		return result;
	}
	
		public static void main(String[] args) {
		MUArrayList<Integer> myList = new MUArrayList<Integer>();
		//test addMiddle
		myList.addMiddle(2);
		myList.add(3);
		myList.addMiddle(4);
		myList.addMiddle(5);
		myList.add(6);
		myList.addMiddle(7);
		System.out.println(myList);
		
		//test indexOf
	}

}