

public class LinkedListPalindrome {
	
	private Node head;
	private static class Node{
		private Node next;
		private int value;
		
		Node(int value){
			this.value= value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListPalindrome list = new LinkedListPalindrome();
		Node head = new Node(1);
		list.addToLast(head);
		list.addToLast(new Node(2));
		list.addToLast(new Node(3));
		list.addToLast(new Node(4));
		list.addToLast(new Node(3));
		list.addToLast(new Node(2));
		list.addToLast(new Node(1));
		
		boolean result = checkPalindrome(head);
		System.out.println(result);
	}
	
	public void addToLast(Node node){
		if(head == null){
			head = node;
		}
		else{
			Node temp = head;
			while(temp.next!=null)
				temp = temp.next;
			temp.next=node;
		}
	}
	
	public static Node middleElement(Node head){
		Node fp = head;
		Node sp = head;
		
		while(fp!=null){
			fp = fp.next;
			if(fp!=null && fp.next!=null){
				fp = fp.next;
				sp = sp.next;
			}
		}
		return sp;
	}
	
	//Reverse the linked list.
	
	public static Node reverseList(Node current){
		Node previous = null;
		Node nextNode;
		
		while(current!=null){
			nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}
		return previous;
	}
	
	public static boolean checkPalindrome(Node head){
		Node middleElement = middleElement(head);
		
		Node secondhead = middleElement.next;
		middleElement.next = null;
		
		Node reverseHead = reverseList(secondhead);
		
		while(head!=null && reverseHead!=null){
			if(head.value == reverseHead.value){
				head = head.next;
				reverseHead=reverseHead.next;
				continue;
			}
			else
				return false;
		}
		return true;
	}

}
