package dsandalgos.trees.binarytree;

public class Node<E> {

	private E value;
	private Node<E> left;
	private Node<E> right;
	
	public Node(final E value) {
		this.value = value;
	}
	
	public E getValue() {
		return value;
	}
	public Node<E> getLeft() {
		return left;
	}
	public Node<E> getRight() {
		return right;
	}
	
	public void setLeft(Node<E> left) {
		this.left = left;
	}
	public void setRight(Node<E> right) {
		this.right = right;
	}
}
