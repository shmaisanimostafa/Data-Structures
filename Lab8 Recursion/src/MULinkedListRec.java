package lab7;

public class MULinkedListRec<E> {

	private Node<E> head;

	private static class Node<E> {
		private E data;
		private Node<E> next;

		private Node(E dataItem) {
			data = dataItem;
			next = null;
		}

		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
	} // end class Node

	private int size(Node<E> head) {
		if (head == null) {
			return 0;
		} else {
			return 1 + size(head.next);
		}
	}

	public int size() {
		return size(head);
	}

	private String toString(Node<E> head) {
		if (head == null) {
			return "";
		} else {
			return head.data + "\n" + toString(head.next);
		}
	}

	@Override
	public String toString() {
		return toString(head);
	}

	private void replace(Node<E> head, E oldObj, E newObj) {
		if (head != null) {
			if (oldObj.equals(head.data)) {
				head.data = newObj;
			}
			replace(head.next, oldObj, newObj);
		}
	}

	public void replace(E oldObj, E newObj) {
		replace(head, oldObj, newObj);
	}

	private void add(Node<E> head, E data) {
		// If the list has just one element, add to it.
		if (head.next == null) {
			head.next = new Node<>(data);
		} else {
			add(head.next, data); // Add to rest of list.
		}
	}
	
	public void add(E data) {
        if (head == null) {
            head = new Node<>(data); // List has 1 node.
        } else {
            add(head, data);
        }
    }
	
	private boolean remove(Node<E> head, Node<E> pred, E outData) {
        if (head == null) // Base case --  empty list.
        {
            return false;
        } else if (head.data.equals(outData)) { // 2nd base case.
            pred.next = head.next; // Remove head.
            return true;
        } else {
            return remove(head.next, head, outData);
        }
    }
	
	public boolean remove(E outData) {
        if (head == null) {
            return false;
        } else if (head.data.equals(outData)) {
            head = head.next;
            return true;
        } else {
            return remove(head.next, head, outData);
        }
    }
}
