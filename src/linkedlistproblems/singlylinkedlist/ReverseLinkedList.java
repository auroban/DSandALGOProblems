package linkedlistproblems.singlylinkedlist;

import java.util.ArrayList;
import java.util.Scanner;

import dsandalgos.linkedlists.singlylinkedlist.Node;

public class ReverseLinkedList {

	public static void main(String[] args) {

		System.out.println("Please enter the elements in the LinkedList:");
		ArrayList<Integer> itemList = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		scanner.close();
//		while (scanner.hasNextInt()) {
//			itemList.add(scanner.nextInt());
//		}
//		scanner.close();
//		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>(itemList);
//		singlyLinkedList.displayItems();
//		reveseLinkedList(singlyLinkedList.getHead());
//		singlyLinkedList.displayItemsFromALinkedList(reveseLinkedList(singlyLinkedList.getHead()));
		int s = scanner.nextInt();
		modifyX(s);
		System.out.println("Value of X: " + s);
	}
	
	private static void modifyX(int x) {
		if (x != 0) {
			modifyX(--x);
		}
	}


	private static Node<Integer> reveseLinkedList(Node<Integer> headNode) {

		if (headNode == null) {
			return null;
		} else {
			Node<Integer> newNode = null;
			//reverse(headNode, null);
			//System.out.println("New Node Head Item:\t" + newNode.getItem());
			System.out.println("Rev Node:\t"  + reverse(headNode, null).getItem());
			return null;
			
		}
	}

	private static Node<Integer> reverse(Node<Integer> currNode, Node<Integer> revNode) {

		
		Node<Integer> newNode = new Node<Integer>(null, currNode.getItem());
		if (revNode != null) {
			newNode.setNext(revNode);
		}
		revNode = newNode;
		if (revNode != null) {
			System.out.println("Rev Node Head Item:\t" + revNode.getItem());
		}
		if (currNode.getNext() != null) {
			return reverse(currNode.getNext(), revNode);
		}
		else {
		return revNode;
		}
	}

}
