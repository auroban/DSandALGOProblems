package dsandalgos.trees.problems.linknodesonsamelevel;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * Given a Binary tree, link nodes of the same level together
 * More: https://www.geeksforgeeks.org/connect-nodes-at-same-level/
 *
 */
class TreeUtil {
	
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
	
	public static <E> String levelOrder(Node<E> root) {
		if (root != null) {
			return traverseLevelOrder(root);
		}
		return null;
	}
	
	public static <E> void linkNodes(Node<E> root) {
		Queue<Node<E>> queue = new LinkedList<>();
		if (root != null) {
			queue.add(root);
			queue.add(Node.nullNode());
			Node<E> temp = queue.remove();
			while (temp != null) {
				if (temp.getLeft() != null) {
					queue.add(temp.getLeft());
				}
				if (temp.getRight() != null) {
					queue.add(temp.getRight());
				}
				
				if (queue.isEmpty()) {
					break;
				}
				
				Node<E> temp2 = queue.remove();
				if (temp2.equals(Node.nullNode())) {
					temp.setNext(null);
					queue.add(Node.nullNode());
					temp2 = queue.remove();
					if (temp2.equals(Node.nullNode())) {
						break;
					}
				} else {
					temp.setNext(temp2);
				}
				temp = temp2;
			}
		}
		
		
		
	}
	
	private static <E> String traverseInOrder(Node<E> node) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" [ ");
		if (node.getLeft() != null) {
			stringBuilder.append(" (" + traverseInOrder(node.getLeft()) + "_LEFT) ");
		}
		stringBuilder.append(node.getData().toString());
		if (node.getRight() != null) {
			stringBuilder.append(" (" + traverseInOrder(node.getRight()) + "_RIGHT) ");
		}
		stringBuilder.append(" ] ");
		return stringBuilder.toString();
	}
	
	private static <E> String traverseLevelOrder(Node<E> node) {

		Queue<Node<E>> queue = new LinkedList<>();
		Node<E> temp = node;
		StringBuilder stringBuilder = new StringBuilder();
		while (temp != null) {
			stringBuilder.append(temp.getData().toString() + "  ");
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
