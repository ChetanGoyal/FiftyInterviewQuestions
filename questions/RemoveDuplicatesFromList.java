package com.topFifty.questions;

/*
 * This will remove the duplicates from the linkedlist.
 * Implemented by two approaches:
 * 1: using Hashset since set cannot have duplicates.
 * 2:Using two pointer approach.
 */
import java.util.HashSet;

public class RemoveDuplicatesFromList {

	private Node head;

	private static class Node {
		private Node next;
		private int value;

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(3);
		RemoveDuplicatesFromList list = new RemoveDuplicatesFromList();
		list.addToLast(head);
		list.addToLast(new Node(3));
		list.addToLast(new Node(4));
		list.addToLast(new Node(5));
		list.addToLast(new Node(6));
		list.addToLast(new Node(6));
		list.addToLast(new Node(7));
		list.addToLast(new Node(8));
		list.printList(head);
		list.RemoveDuplicateRunner(head);
		System.out.println("After the removal");
		list.printList(head);
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

	public void RemoveDupHashSet(Node head) {
		Node previous = null;
		HashSet<Integer> set = new HashSet<>();

		while (head != null) {
			if (set.contains(head.value)) {
				previous.next = head.next;
			} else {
				set.add(head.value);
				previous = head;
			}
			head = head.next;
		}
	}

	public void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	public void RemoveDuplicateRunner(Node head) {
		Node current = head;
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.value == current.value) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

}
