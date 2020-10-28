package dsandalgos.linkedlists.doublylinkedlist;

import java.util.ArrayList;

public class DoublyLinkedList<E> {

	public Node<E> head = null;

	public DoublyLinkedList(ArrayList<E> itemList) {
		if (itemList != null && itemList.size() > 0) {
			beginInsertion(itemList);
		}
	}

	public Node<E> getHead() {
		return head;
	}

	public void displayItems() {

		if (head == null) {
			System.out.println("Oops!! Nothing to display");
		} else {
			System.out.println(printItems(head));
		}
	}

	public void displayItemsFromLinkedList(Node<E> node) {
		if (node == null) {
			System.out.println("Oops!! Nothing to display");
		} else {
			System.out.println(printItems(node));
		}
	}

	public Node<E> insertAtFront(Node<E> newNode) {
		newNode.setNext(head);
		head.setPrevious(newNode);
		head = newNode;
		return head;
	}

	public Node<E> insertAtEnd(Node<E> newNode) {

		Node<E> node = head;
		while (node != null && node.getNext() != null) {
			node = node.getNext();
		}
		node.setNext(newNode);
		newNode.setPrevious(node);
		return head;
	}

	public Node<E> insertAfterGivenNode(Node<E> newNode, E item) {

		Node<E> node = head;
		while (node != null) {
			if (node.getItem().equals(item)) {
				if (node.getNext() != null) {
					Node<E> afterNode = node.getNext();
					node.setNext(newNode);
					newNode.setPrevious(node);
					newNode.setNext(afterNode);
					afterNode.setPrevious(newNode);
				} else {
					node.setNext(newNode);
					newNode.setPrevious(node);
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
		head.setPrevious(null);
		temp.setNext(null);
		temp = null;
		return head;
	}

	public Node<E> deleteAtEnd() {
		Node<E> node = head;
		while (node != null && node.getNext().getNext() != null) {
			node = node.getNext();
		}
		Node<E> temp = node.getNext();
		node.setNext(null);
		temp.setPrevious(null);
		temp = null;
		return head;
	}

	public Node<E> deleteAtAGivenPoint(E point) {
		Node<E> node = head;
		Node<E> temp = null;
		if (node != null && node.getItem().equals(point)) {
			return deleteAtFront();
		}
		while (node != null && node.getNext() != null) {
			if (node.getNext().getItem().equals(point)) {
				temp = node.getNext();
				if (temp.getNext() != null) {
					node.setNext(temp.getNext());
					temp.getNext().setPrevious(node);
					temp.setNext(null);
					temp.setPrevious(null);
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

	private void beginInsertion(ArrayList<E> itemList) {
		for (int i = 0; i < itemList.size(); i++) {
			if (head == null) {
				head = new Node<E>(null, null, itemList.get(i));
			} else {
				populateLinkedList(head, itemList.get(i));
			}
		}
	}

	private void populateLinkedList(Node<E> node, E item) {
		if (node.getNext() == null) {
			Node<E> newNode = new Node<E>(node, null, item);
			node.setNext(newNode);
		} else {
			populateLinkedList(node.getNext(), item);
		}
	}

	private String printItems(Node<E> node) {
		StringBuilder result = new StringBuilder();
		while (node != null) {
			if (node.getPrevious() != null) {
				result.append(" <--> ");
			}
			result.append(node.getItem());
			node = node.getNext();
		}
		return result.toString();
	}

}
