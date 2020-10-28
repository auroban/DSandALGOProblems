package dsandalgos.linkedlists.doublylinkedlist;

public class Node<E> {
	
	private Node<E> prev;
	private Node<E> next;
	private E item;
	
	public Node(Node<E> prev, Node<E> next, E item) {
		
		this.prev = prev;
		this.next = next;
		this.item = item;
	}
	
	// Getters
	public Node<E> getPrevious() {
		return prev;
	}
	public Node<E> getNext() {
		return next;
	}
	public E getItem() {
		return item;
	}
	
	// Setters
	public void setPrevious(Node<E> prev) {
		this.prev = prev;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
	public void setItem(E item) {
		this.item = item;
	}

}
