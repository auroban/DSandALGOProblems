package dsandalgos.linkedlists.singlylinkedlist;

public class Node<E> {
	
	private Node<E> next;
	private E item;
	
	public Node(Node<E> next, E item) {
		this.next = next;
		this.item = item;
	}
	
	
	// Getters
	public E getItem() {
		return item;
	}
	
	public Node<E> getNext() {
		return next;
	}
	
	// Setters
	public void setNext(Node<E> next) {
		this.next = next;
	}

}
