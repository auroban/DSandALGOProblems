package dsandalgos.linkedlists.doublylinkedlist.problems;

import java.util.ArrayList;
import java.util.Scanner;

import dsandalgos.linkedlists.doublylinkedlist.DoublyLinkedList;
import dsandalgos.linkedlists.doublylinkedlist.Node;

public class ReverseLinkedListProblem {

	public static void main(String[] args) {
		
		System.out.println("Please enter the number of elements of the LinkedList");
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> itemList = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
			itemList.add(scanner.nextInt());
		}
		scanner.close();
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>(itemList);
		System.out.println("Formed LinkedList");
		doublyLinkedList.displayItems();
		System.out.println("\n\nReversed LinkedList");
		doublyLinkedList.displayItemsFromLinkedList(reverseLinkedList(doublyLinkedList.getHead()));
	}
	
	private static Node<Integer> reverseLinkedList(Node<Integer> node) {
		Node<Integer> resultantNode = null;
		Node<Integer> tempNode = null;
		
		while (node != null) {
			tempNode = resultantNode;
			resultantNode = new Node<Integer>(null, null, node.getItem());
			resultantNode.setNext(tempNode);
			if (tempNode != null) {
				tempNode.setPrevious(resultantNode);
			}
			node = node.getNext();
		}
		
		tempNode = null;
		return resultantNode;
	}

}
