package dsandalgos.linkedlists.linkedlistproblems.circularlinkedlist.singlylinkedlist;

import java.util.ArrayList;
import java.util.Scanner;

import dsandalgos.linkedlists.circularlinkedlists.circularsingly.CircularSinglyLinkedList;
import dsandalgos.linkedlists.circularlinkedlists.circularsingly.Node;

public class FindLengthIteration {

	public static void main(String[] args) {

		System.out.println("Please enter the elements into the LinkedList:\t");
		ArrayList<Integer> itemList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt())
			itemList.add(scanner.nextInt());
		scanner.close();
		CircularSinglyLinkedList<Integer> linkedList = new CircularSinglyLinkedList<>(itemList);
		Node<Integer> head = linkedList.getHead();
		System.out.println("Length of the LinkedList:\t" + findLength(head));
	}

	private static int findLength(Node<Integer> head) {
		int length = 0;
		if (head == null)
			return length;
		else {
			Node<Integer> node = head.getNext();
			length++;
			while (node != null && node != head) {
				length++;
				node = node.getNext();
			}
			return length;
		}
	}

}
