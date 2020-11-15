package dsandalgos.linkedlists.linkedlistproblems.singlylinkedlist;

import java.util.ArrayList;
import java.util.Scanner;

import dsandalgos.linkedlists.singlylinkedlist.Node;
import dsandalgos.linkedlists.singlylinkedlist.SinglyLinkedList;

public class FindLengthIteration {

	public static void main(String[] args) {

		System.out.println("Please enter the items of the LinkedList");
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> items = new ArrayList<>();
		while (input.hasNextInt()) {
			items.add(input.nextInt());
		}
		input.close();
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>(items);
		Node<Integer> head = linkedList.getHead();
		System.out.println("The length of the LinkedList is:\t" + findLength(head));

	}

	private static int findLength(Node<Integer> head) {
		int length = 0;
		Node<Integer> node = head;
		while (node != null) {
			length++;
			node = node.getNext();
		}
		return length;
	}

}
