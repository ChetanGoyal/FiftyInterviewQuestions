

/*
 * This program performs variety of operation on lists.
 * Every function description is provided before the function.
 */

public class MiddleElementLinkedList {
	private static class Node {
		private int value;
		private Node next;

		Node(int value) {
			this.value = value;
		}
	}

	private Node head;

	public static void main(String[] args) {
		MiddleElementLinkedList list = new MiddleElementLinkedList();
		Node head = new Node(5);
		list.addToLast(head);
		list.addToLast(new Node(7));
		list.addToLast(new Node(1));
		list.addToLast(new Node(2));
		list.addToLast(new Node(4));
		list.addToLast(new Node(4));
		list.addToLast(new Node(10));

		Node element = list.findMiddle(head);
		System.out.println("Middle element is:" + element.value);
		int location = 3;
		Node nthElement = list.nthElementfromLast(head, location);
		System.out.printf("Element from the %d position: %d", location, nthElement.value);
		System.out.println();
		// Node reverseHead = reverseList(head);
		// System.out.println("Head after reversal is:" + reverseHead.value);

		System.out.println("List reversed is:");
		reverseRecursion(head);
	}

	/*
	 * This will add the elements at the last of the list.
	 */
	public void addToLast(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}

	/*
	 * This will find the middle of the element in one pass.
	 */
	public Node findMiddle(Node head) {
		Node onehopPointer, twoHopPointer;
		onehopPointer = twoHopPointer = head;

		while (twoHopPointer != null) {
			twoHopPointer = twoHopPointer.next;
			if (twoHopPointer != null && twoHopPointer.next != null) {
				onehopPointer = onehopPointer.next;
				twoHopPointer = twoHopPointer.next;
			}
		}
		return onehopPointer;
	}

	/*
	 * This will find the nth element from the last of the linked list.
	 */
	public Node nthElementfromLast(Node head, int n) {
		Node firstPointer;
		Node secondPointer;
		firstPointer = secondPointer = head;

		for (int i = 0; i < n; i++) {
			firstPointer = firstPointer.next;
		}
		while (firstPointer != null) {
			firstPointer = firstPointer.next;
			secondPointer = secondPointer.next;
		}

		return secondPointer;
	}

	/*
	 * This will reverse the linked list using iterative method or we can say in
	 * place reversal.
	 */
	public static Node reverseList(Node currentNode) {
		Node previousNode = null;
		Node nextNode;
		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		return previousNode;
	}

	/*
	 * This will print the reverse of the linked list recursively.
	 */
	public static void reverseRecursion(Node current) {

		if (current != null) {
			reverseRecursion(current.next);
			System.out.println(current.value);
		}

	}

}
