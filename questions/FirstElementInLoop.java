package com.topFifty.questions;

public class FirstElementInLoop {
	private Node head;

	private static class Node {
		private Node next;
		private int value;

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		FirstElementInLoop list = new FirstElementInLoop();
		Node head = new Node(4);

		list.addToLast(new Node(5));
		list.addToLast(new Node(7));
		list.addToLast(new Node(6));
		list.addToLast(new Node(8));
		list.addToLast(head);
		list.addToLast(new Node(10));
		list.addToLast(new Node(12));
		list.addToLast(new Node(1));
		list.addToLast(head);

		Node start = list.BeginningElementLoop();
		System.out.println(start.value);
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

	/*
	 * This is an extension to finding the loop of the element. if loop exist,
	 * then assign the head to sp and iterate till sp ! = fp and move one step
	 * forward. otherwise assign null to sp and return sp.
	 */
	public Node BeginningElementLoop() {
		Node fp = head;
		Node sp = head;
		boolean isLoop = false;
		while (fp != null) {
			fp = fp.next;
			if (fp != null && fp.next != null) {
				fp = fp.next;
				sp = sp.next;
				if (fp == sp) {
					isLoop = true;
					break;
				}
			}
		}
		if (isLoop) {
			sp = head;
			while (sp != fp) {
				sp = sp.next;
				fp = fp.next;
			}
		} else
			sp = null;
		return sp;
	}

}
