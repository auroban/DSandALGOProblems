package linkedlistproblems.doublylinkedlist;

import java.util.ArrayList;
import java.util.Scanner;

import dsandalgos.linkedlists.doublylinkedlist.DoublyLinkedList;
import dsandalgos.linkedlists.doublylinkedlist.Node;

public class FindLengthIteration {

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
		System.out.println("The length of the LinkedList:\t" + findLength(head));
	}

	private static int findLength(Node<Integer> head) {
		int length = 0;
		if (head == null) {
			return length;
		} else {
			length++;
			Node<Integer> node = head.getNext();
			while (node != null) {
				length++;
				node = node.getNext();
			}
			return length;
		}
	}

}
