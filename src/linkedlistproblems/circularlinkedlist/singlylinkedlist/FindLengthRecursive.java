package linkedlistproblems.circularlinkedlist.singlylinkedlist;

import java.util.ArrayList;
import java.util.Scanner;

import dsandalgos.linkedlists.circularlinkedlists.circularsingly.CircularSinglyLinkedList;
import dsandalgos.linkedlists.circularlinkedlists.circularsingly.Node;

public class FindLengthRecursive {

	public static void main(String[] args) {
		System.out.println("Please enter the elements into the LinkedList:\t");
		ArrayList<Integer> itemList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt())
			itemList.add(scanner.nextInt());
		scanner.close();
		CircularSinglyLinkedList<Integer> linkedList = new CircularSinglyLinkedList<>(itemList);
		Node<Integer> head = linkedList.getHead();
		int length = 0;
		if (head != null) {
			length = findLength(head, head.getNext(), ++length);
		}
		System.out.println("The Length is:\t" + length);
	}

	private static int findLength(Node<Integer> head, Node<Integer> node, int length) {
		if (node != null && node != head)
			length = findLength(head, node.getNext(), ++length);
		return length;
	}

}
