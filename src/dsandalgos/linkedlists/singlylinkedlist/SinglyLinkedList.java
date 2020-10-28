package dsandalgos.linkedlists.singlylinkedlist;

import java.util.ArrayList;

public class SinglyLinkedList<E> {

	private Node<E> head = null;

	public SinglyLinkedList(ArrayList<E> itemList) {

		beginInsertion(itemList);
	}

	public void displayItemsFromALinkedList(Node<E> node) {
		if (node == null) {
			System.out.println("Oops!! Nothing to display");
		} else {
			System.out.println(printItems(node));
		}
	}

	public void displayItems() {
		if (head == null) {
			System.out.println("Oops!! Nothing to display");
		} else {
			System.out.println(printItems(head));
		}
	}

	public Node<E> getHead() {
		return head;
	}

	public Node<E> insertAtFront(Node<E> newNode) {
		newNode.setNext(head);
		head = newNode;
		return head;
	}

	public Node<E> insertAtEnd(Node<E> newNode) {
		Node<E> node = head;
		while (node != null && node.getNext() != null) {
			node = node.getNext();
		}
		node.setNext(newNode);
		return head;
	}

	public Node<E> insertAfterAGivenNode(Node<E> newNode, E item) {

		Node<E> node = head;
		while (node != null) {
			if (node.getItem().equals(item)) {
				if (node.getNext() != null) {
					Node<E> afterNode = node.getNext();
					node.setNext(newNode);
					newNode.setNext(afterNode);
				} else {
					node.setNext(newNode);
				}
				break;
			}
			node = node.getNext();
		}
		return head;
	}

	public Node<E> deleteAtFront() {
		Node<E> temp = head;
		head = head.getNext();
		temp.setNext(null);
		temp = null;
		return head;
	}

	public Node<E> deleteAtEnd() {
		Node<E> node = head;
		while (node != null && node.getNext().getNext() != null) {
			node = node.getNext();
		}
		node.setNext(null);
		return head;
	}

	public Node<E> deleteAtAGivenPoint(E point) {
		Node<E> node = head;
		Node<E> temp = null;
		if (node != null && point.equals(node.getItem())) {
			return deleteAtFront();
		}
		while (node != null && node.getNext() != null) {
			if (node.getNext().getItem().equals(point)) {
				if (node.getNext().getNext() != null) {
					temp = node.getNext();
					node.setNext(temp.getNext());
					temp.setNext(null);
					temp = null;
					break;
				} else {
					return deleteAtEnd();
				}
			}
			node = node.getNext();
		}
		return head;
	}

	private String printItems(Node<E> node) {

		if (node.getNext() == null) {
			return node.getItem().toString();
		} else {
			String reString = node.getItem().toString() + " --> ";
			return reString + printItems(node.getNext());
		}
	}

	private void beginInsertion(ArrayList<E> itemList) {

		if (itemList != null && itemList.size() > 0) {
			for (int i = 0; i < itemList.size(); i++) {
				if (head == null) {
					head = new Node<E>(null, itemList.get(i));
				} else {
					insertIntoLinkedList(head, itemList.get(i));
				}
			}
		}
	}

	private void insertIntoLinkedList(Node<E> node, E item) {

		if (node.getNext() == null) {
			node.setNext(new Node<E>(null, item));
		} else {
			insertIntoLinkedList(node.getNext(), item);
		}
	}
}
