package dsandalgos.linkedlists.circularlinkedlists.circularsingly;

import java.util.ArrayList;

public class CircularSinglyLinkedList<E> {

	private Node<E> head;
	private String reString;

	public CircularSinglyLinkedList(ArrayList<E> itemList) {
		reString = "";
		for (E item : itemList) {
			if (head == null) {
				head = new Node<E>(item, null);
				head.setNext(head);
			} else {
				populateLinkedList(head, item);
			}
		}
	}

	public Node<E> getHead() {
		return head;
	}

	public void displayItems() {
		printItem(head);
		System.out.println(reString);
	}

	public void displayItemsFromLinkedList(Node<E> node) {
		printItem(node);
		System.out.println(reString);
	}

	private void populateLinkedList(Node<E> currentNode, E item) {
		if (currentNode.getNext() != null && currentNode.getNext() == head) {
			Node<E> node = new Node<E>(item, head);
			currentNode.setNext(node);
		} else {
			populateLinkedList(currentNode.getNext(), item);
		}
	}

	private void printItem(Node<E> node) {
		if (node != null) {
			reString = reString + node.getItem();
			if (node.getNext() != null && node.getNext() != head) {
				reString = reString + " -- > ";
				printItem(node.getNext());
			} else if (node.getNext() != null && node.getNext() == head) {
				reString = " -- > " + reString + " --> ";
			}
		}
	}

}
