package LinkedList;

/**
 * Class to represent a linked list with a link from each node to the next node.
 * SingleLinkedList does not implement the List interface.
 */
public class MUSingleLinkedList<E> {

	/** Reference to list head. */
	private Node<E> head = null;
	/** The number of items in the list */
	private int size = 0;

	public static class Node<E> {
		private E data;
		private Node<E> next;

		/**
		 * Creates a new node with a null next field
		 * 
		 * @param dataItem The data stored
		 */
		public Node(E data) {
			this.data = data;
			next = null;
		}

		/**
		 * Creates a new node that references another node
		 * 
		 * @param dataItem The data stored
		 * @param nodeRef  The node referenced by new node
		 */
		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}

	}

	public void addFirst(E item) {
		head = new Node<>(item, head);
		size++;
	}

	/**
	 * Add a node after a given node
	 * 
	 * @param node The node preceding the new item
	 * @param item The item to insert
	 */
	private void addAfter(Node<E> node, E item) {
		node.next = new Node<>(item, node.next);
		size++;
	}

	/**
	 * Remove the node after a given node
	 * 
	 * @param node The node before the one to be removed
	 * @return The data from the removed node, or null if there is no node to remove
	 */
	private E removeAfter(Node<E> node) {
		Node<E> temp = node.next;
		if (temp != null) {
			node.next = temp.next;
			size--;
			return temp.data;
		} else {
			return null;
		}
	}

	/**
	 * Remove the first node from the list
	 * 
	 * @return The removed node's data or null if the list is empty
	 */
	private E removeFirst() {
		Node<E> temp = head;
		if (head != null) {
			head = head.next;
		}
		// Return data at old head or null if list is empty
		if (temp != null) {
			size--;
			return temp.data;
		} else {
			return null;
		}
	}

	/**
	 * Find the node at a specified position
	 * 
	 * @param index The position of the node sought
	 * @return The node at index or null if it does not exist
	 */
	private Node<E> getNode(int index) {
		Node<E> node = head;
		for (int i = 0; i < index && node != null; i++) {
			node = node.next;
		}
		return node;
	}

	/**
	 * Get the data at index
	 * 
	 * @param index The position of the data to return
	 * @return The data at index
	 * @throws IndexOutOfBoundsException if index is out of range
	 */

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		}
		Node<E> node = getNode(index);
		return node.data;
	}

	/**
	 * Store a reference to anEntry in the element at position index.
	 * 
	 * @param index    The position of the item to change
	 * @param newValue The new data
	 * @return The data previously at index
	 * @throws IndexOutOfBoundsException if index is out of range
	 */
	public E set(int index, E newValue) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		}
		Node<E> node = getNode(index);
		E result = node.data;
		node.data = newValue;
		return result;
	}

	/**
	 * Insert the specified item at index
	 * 
	 * @param index The position where item is to be inserted
	 * @param item  The item to be inserted
	 * @throws IndexOutOfBoundsException if index is out of range
	 */

	public void add(int index, E item) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(index);
		}
		if (index == 0) {
			addFirst(item);
		} else {
			Node<E> node = getNode(index - 1);
			addAfter(node, item);
		}
	}

	/**
	 * Append item to the end of the list
	 * 
	 * @param item The item to be appended
	 * @return true (as specified by the Collection interface)
	 */
	public boolean add(E item) {
		add(size, item);
		return true;
	}

	// lab 2 exercise: Question 2, part 1
	@Override
	public String toString() {
		Node<E> nodeRef = head;
		StringBuilder result = new StringBuilder();
		while (nodeRef != null) {
			result.append(nodeRef.data);
			if (nodeRef.next != null) {
				result.append(" ==> ");
			}
			nodeRef = nodeRef.next;
		}
		return result.toString();
	}

	// lab 3 exercise: Question 2, part 2
	public int size() {
		return size;
	}

	// lab 3 exercise: Question 2, part 2
	public int indexOf(E item) {
		Node<E> nodeRef = head;
		int index = 0;
		while (nodeRef != null) {
			if (nodeRef.data.equals(item))
				return index;
			index++;
			nodeRef = nodeRef.next;
		}
		return -1;
	}

	// lab 3 exercise: Question 2, part 2
	public E remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException(index);
		if (index == 0)
			return removeFirst();
		else {
			Node<E> nodeRef = getNode(index - 1);
			return removeAfter(nodeRef);
		}
	}

	
	// lab 3 exercise: Question 2, part 3
	
	

	
	// lab 3 exercise: Question 2, part 4
	

}
