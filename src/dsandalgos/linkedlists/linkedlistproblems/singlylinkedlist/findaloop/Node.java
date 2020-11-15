package dsandalgos.linkedlists.linkedlistproblems.singlylinkedlist.findaloop;

class Node {

	private int value;
	private Node next;

	Node(int value) {
		this.value = value;
	}

	int getValue() {
		return value;
	}

	void setNext(Node next) {
		this.next = next;
	}

	Node getNext() {
		return next;
	}
}
