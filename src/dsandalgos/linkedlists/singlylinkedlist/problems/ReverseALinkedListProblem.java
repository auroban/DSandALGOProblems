package dsandalgos.linkedlists.singlylinkedlist.problems;

import java.util.ArrayList;
import java.util.Scanner;

import dsandalgos.linkedlists.singlylinkedlist.Node;
import dsandalgos.linkedlists.singlylinkedlist.SinglyLinkedList;

public class ReverseALinkedListProblem {

	public static void main(String[] args) {
		
		System.out.println("Please enter the elements of the LinkedList");
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> itemList = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
			itemList.add(scanner.nextInt());
		}
		scanner.close();
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(itemList);
		System.out.println("The formed LinkedList is");
		singlyLinkedList.displayItems();
		System.out.println("Reversing the LinkedList");
		singlyLinkedList.displayItemsFromALinkedList(reverseLinkedList(singlyLinkedList.getHead()));
	}
	
	private static Node<Integer> reverseLinkedList(Node<Integer> node) {
		
		Node<Integer> resultantNode = null;
		Node<Integer> tempNode = null;
		
		while (node!=null) {
			tempNode = resultantNode;
			resultantNode = new Node<Integer>(null, node.getItem());
			resultantNode.setNext(tempNode);
			node = node.getNext();
		}
		
		tempNode = null;
		return resultantNode;
	}

}
