package dsandalgos.linkedlists.circularlinkedlists.circulardoubly;

public class Node<E> {
	
	private Node<E> prev;
	private Node<E> next;
	private E item;
	
	public Node(E item, Node<E> prev, Node<E> next) {
		this.item = item;
		this.prev = prev;
		this.next = next;
	}
	
	// Getters
	public E getItem() {
		return item;
	}
	public Node<E> getPrev() {
		return prev;
	}
	public Node<E> getNext() {
		return next;
	}
	
	// Setters
	public void setItem(E item) {
		this.item = item;
	}
	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}

}
