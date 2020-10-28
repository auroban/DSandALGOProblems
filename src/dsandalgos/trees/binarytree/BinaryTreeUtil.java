package dsandalgos.trees.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeUtil {

	public static <E> Node<E> getBinaryTree(final List<E> list) {
		E[] items = null;
		items = list.toArray(items);
		System.out.println(items.length);
		return getBinaryTree(items);
	}

	public static <E> Node<E> getBinaryTree(final E[] array) {
		Queue<Node<E>> queue = new LinkedList<>();
		Node<E> root = null;

		if (array != null && array.length > 0) {
			Node<E> temp = null;
			for (E value : array) {
				if (value != null) {
					if (root == null) {
						root = new Node<E>(value);
						temp = root;
					} else if (temp.getLeft() == null) {
						temp.setLeft(new Node<E>(value));
						queue.add(temp.getLeft());
					} else {
						temp.setRight(new Node<E>(value));
						queue.add(temp.getRight());
						temp = queue.remove();
					}
				}
			}
		}

		return root;
	}
	
	public static <E> String inOrder(Node<E> root) {
		if (root != null) {
			return traverseInOrder(root);
		}
		return null;
	}

	public static <E> String preOrder(Node<E> root) {
		if (root != null) {
			return traversePreOrder(root);
		}
		return null;
	}

	public static <E> String postOrder(Node<E> root) {
		if (root != null) {
			return traversePostOrder(root);
		}
		return null;
	}
	
	public static <E> String levelOrder(Node<E> root) {
		if (root != null) {
			return traverseLevelOrder(root);
		}
		return null;
	}

	private static <E> String traverseInOrder(Node<E> node) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" [ ");
		if (node.getLeft() != null) {
			stringBuilder.append(" (" + traverseInOrder(node.getLeft()) + "_LEFT) ");
		}
		stringBuilder.append(node.getValue().toString());
		if (node.getRight() != null) {
			stringBuilder.append(" (" + traverseInOrder(node.getRight()) + "_RIGHT) ");
		}
		stringBuilder.append(" ] ");
		return stringBuilder.toString();
	}

	private static <E> String traversePreOrder(Node<E> node) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" [");
		stringBuilder.append(node.getValue().toString());
		if (node.getLeft() != null) {
			stringBuilder.append(" (" + traversePreOrder(node.getLeft()) + ") ");
		}
		if (node.getRight() != null) {
			stringBuilder.append(" (" + traversePreOrder(node.getRight()) + ") ");
		}
		stringBuilder.append("] ");
		return stringBuilder.toString();
	}

	private static <E> String traversePostOrder(Node<E> node) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" [ ");
		if (node.getLeft() != null) {
			stringBuilder.append(" (" + traversePostOrder(node.getLeft()) + "_LEFT)");
		}
		if (node.getRight() != null) {
			stringBuilder.append(" (" + traversePostOrder(node.getRight()) + "_RIGHT)");
		}
		stringBuilder.append(node.getValue().toString());
		stringBuilder.append(" ] ");
		return stringBuilder.toString();
	}

	private static <E> String traverseLevelOrder(Node<E> node) {

		Queue<Node<E>> queue = new LinkedList<>();
		Node<E> temp = node;
		StringBuilder stringBuilder = new StringBuilder();
		while (temp != null) {
			stringBuilder.append(temp.getValue().toString() + "  ");
			if (temp.getLeft() != null) {
				queue.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				queue.add(temp.getRight());
			}
			if (queue.isEmpty()) {
				break;
			}
			temp = queue.remove();
		}
		return stringBuilder.toString();
	}

}
