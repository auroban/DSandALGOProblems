package dsandalgos.linkedlists.linkedlistproblems.doublylinkedlist;

import java.util.ArrayList;
import java.util.Scanner;

import dsandalgos.linkedlists.doublylinkedlist.DoublyLinkedList;
import dsandalgos.linkedlists.doublylinkedlist.Node;

public class FindLengthRecursive {

	public static void main(String[] args) {

		System.out.println("Enter the elements into the LinkedList");
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> itemList = new ArrayList<>();
		while (scanner.hasNextInt()) {
			itemList.add(scanner.nextInt());
		}
		scanner.close();
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>(itemList);
		Node<Integer> head = doublyLinkedList.getHead();
		int length = 0;
		System.out.println("The length of the LinkedList:\t" + findLength(head, length));
	}

	private static int findLength(Node<Integer> node, int length) {
		if (node != null) {
			length = findLength(node.getNext(), ++length);
		}
		return length;
	}

}
