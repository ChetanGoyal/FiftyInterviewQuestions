package com.topFifty.questions;

//This will delete the middle element of the list.

public class MiddleNodeDelete {

	private Node head;

	private static class Node {
		private Node next;
		private char value;

		Node(char value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiddleNodeDelete list = new MiddleNodeDelete();
		Node head = new Node('a');
		list.addToLast(head);
		list.addToLast(new Node('b'));
		list.addToLast(new Node('c'));
		list.addToLast(new Node('d'));
		list.addToLast(new Node('e'));
		list.addToLast(new Node('f'));
		list.printList();
		list.middleElementDelete(head);
		list.printList();
	}

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

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.format("%s ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	/*
	 * This will delete the middle of the linkedlist.
	 */
	public void middleElementDelete(Node head) {
		Node fp = head;
		Node sp = head;
		Node previous = null;
		while (fp != null) {
			fp = fp.next;
			if (fp != null && fp.next != null) {
				fp = fp.next;
				previous = sp;
				sp = sp.next;
			}
		}
		previous.next = sp.next;
	}
}
