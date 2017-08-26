package com.topFifty.questions;

public class LoopLinkedList {
	private static class Node {
		private int value;
		private Node next;

		Node(int value) {
			this.value = value;
		}
	}

	private Node head;

	public static void main(String[] args) {
		LoopLinkedList list = new LoopLinkedList();
		Node head = new Node(5);
		list.addToLast(new Node(7));
		list.addToLast(new Node(1));
		list.addToLast(new Node(2));
		list.addToLast(head);
		list.addToLast(new Node(4));
		list.addToLast(new Node(4));
		list.addToLast(new Node(10));
		list.addToLast(head);

		boolean result = list.loopExist();
		System.out.println(result);
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
	 * This function will find the loop if it exists or not. It is similar to
	 * finding the middle element of the list but with one edition of checking
	 * first pointer along with second pointer.
	 * 
	 */
	public boolean loopExist() {

		Node fp = head;
		Node sp = head;
		while (fp != null) {
			fp = fp.next;
			if (fp != null && fp.next != null) {
				fp = fp.next;
				sp = sp.next;
				if (fp == sp) {
					return true;
				}
			}
		}
		return false;
	}
}
