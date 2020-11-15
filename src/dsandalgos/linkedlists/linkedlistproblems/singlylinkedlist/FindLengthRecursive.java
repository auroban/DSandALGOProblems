package dsandalgos.linkedlists.linkedlistproblems.singlylinkedlist;

import java.util.ArrayList;
import java.util.Scanner;

import dsandalgos.linkedlists.singlylinkedlist.Node;
import dsandalgos.linkedlists.singlylinkedlist.SinglyLinkedList;

public class FindLengthRecursive {

	public static void main(String[] args) {

		System.out.println("Please enter the elements of the LinkedList");
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> items = new ArrayList<>();
		while (scanner.hasNextInt()) {
			items.add(scanner.nextInt());
		}
		scanner.close();
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>(items);
		Node<Integer> head = linkedList.getHead();
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
