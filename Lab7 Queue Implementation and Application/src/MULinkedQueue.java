package lab6;

public class MULinkedQueue<E> {

	// Data Fields
	/** Reference to front of queue. */
	private Node<E> front;
	/** Reference to rear of queue. */
	private Node<E> rear;
	/** Size of queue. */
	private int size;

	private static class Node<E> {
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

	// Methods
	/**
	 * Insert an item at the rear of the queue.
	 * 
	 * @post item is added to the rear of the queue.
	 * @param item The element to add
	 * @return true (always successful)
	 */
	public boolean offer(E item) {
		// Check for empty queue.
		if (front == null) {
			rear = new Node<>(item);
			front = rear;
		} else {
			// Allocate a new node at end, store item in it, and
			// link it to old end of queue.
			rear.next = new Node<>(item);
			rear = rear.next;
		}
		size++;
		return true;
	}

	/**
	 * Remove the entry at the front of the queue and return it if the queue is not
	 * empty.
	 * 
	 * @post front references item that was second in the queue.
	 * @return The item removed if successful, or null if not
	 */
	public E poll() {
		E item = peek();
		// Retrieve item at front.
		if (item == null)
			return null;
		// Remove item at front.
		front = front.next;
		size--;
		// Return data at front of queue.
		return item;
	}

	/**
	 * Return the item at the front of the queue without removing it.
	 * 
	 * @return The item at the front of the queue if successful; return null if the
	 *         queue is empty
	 */
	public E peek() {
		if (size == 0)
			return null;
		else
			return front.data;
	}

	/**
	 * Move the element currently at the front of the queue to the rear of the
	 * queue. Does nothing if the queue is empty or has only one item.
	 */
	public void moveToRear() {
		if (size == 0 || size == 1) {
			return;
		}
		Node<E> oldFront = front;
		front = front.next;
		rear.next = oldFront;
		rear = rear.next;
	}
}