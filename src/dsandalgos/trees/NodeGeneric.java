package dsandalgos.trees;

public class NodeGeneric<E> {

	private E value;
	private NodeGeneric<E> left;
	private NodeGeneric<E> right;
	
	public NodeGeneric(final E value) {
		this.value = value;
	}
	
	public void setLeft(NodeGeneric<E> left) {
		this.left = left;
	}
	
	public void setRight(NodeGeneric<E> right) {
		this.right = right;
	}
	
	public NodeGeneric<E> getLeft() {
		return left;
	}
	
	public NodeGeneric<E> getRight() {
		return right;
	}
	
	public E getValue() {
		return value;
	}
	
}
