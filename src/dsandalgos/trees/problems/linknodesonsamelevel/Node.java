package dsandalgos.trees.problems.linknodesonsamelevel;

class Node<E> {
	
	private static final Node<?> NULL = new Node<>(null);

	private E data;
	private Node<E> left;
	private Node<E> right;
	private Node<E> next;
	
	public Node(final E data) {
		this.data = data;
	}
	
	public E getData() {
		return data;
	}
	public Node<E> getLeft() {
		return left;
	}
	public Node<E> getRight() {
		return right;
	}
	public Node<E> getNext() {
		return next;
	}
	
	public void setLeft(Node<E> left) {
		this.left = left;
	}
	public void setRight(Node<E> right) {
		this.right = right;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	@SuppressWarnings("unchecked")
	public static<E> Node<E> nullNode() {
		return (Node<E>) NULL;
	}
}
