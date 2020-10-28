package dsandalgos.trees;

import java.util.List;

import dsandalgos.queues.Queue;
import dsandalgos.queues.QueueUnderflowException;

public class BinarySearchTreeUtils {

	private static BinarySearchTreeUtils binarySearchTreeUtils;
	private static final String MSG_ERROR_NULL = "Oops!! Nothing to display";
	private static final String MSG_INORDER = "The In-Order traversal of the given BST is:";
	private static final String MSG_PREORDER = "The Pre-Order traversal of the given BST is:";
	private static final String MSG_POSTORDER = "The Post-Order traversal of the given BST is:";

	private BinarySearchTreeUtils() {
	}

	public static BinarySearchTreeUtils getInstance() {

		if (binarySearchTreeUtils == null) {
			binarySearchTreeUtils = new BinarySearchTreeUtils();
		}
		return binarySearchTreeUtils;
	}

	public <E> NodeGeneric<E> getBinaryTree(List<E> elements) {

		NodeGeneric<E> root = null;
		Queue<NodeGeneric<E>> queue = new Queue<>();
		for (E e : elements) {

			System.out.println("Inserting element: " + e);
			if (root == null) {
				root = new NodeGeneric<E>(e);
			} else {
				NodeGeneric<E> temp = root;
				while (temp != null) {
					System.out.println("Value of TEMP: " + temp.getValue());
					if (temp.getLeft() != null)
						System.out.println(temp.getLeft().getValue());
					if (temp.getRight() != null)
						System.out.println(temp.getRight().getValue());
					if (temp.getLeft() == null) {
						temp.setLeft(new NodeGeneric<E>(e));
						break;
					} else if (temp.getRight() == null) {
						temp.setRight(new NodeGeneric<E>(e));
						break;
					} else {
						queue.enqueue(temp.getLeft());
						queue.enqueue(temp.getRight());
						try {
							if (!queue.isQueueEmpty()) {
								temp = queue.dequeue();
							}
						} catch (QueueUnderflowException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		}
		return root;
	}

	public Node getBinarySearchTree(List<Integer> itemList) {
		Node rootNode = null;
		for (Integer item : itemList) {
			if (rootNode == null) {
				rootNode = new Node(item);
			} else {
				traverseAndAdd(item, rootNode);
			}
		}
		return rootNode;
	}

	public void inOrder(Node bst) {
		if (bst == null) {
			System.out.println(MSG_ERROR_NULL);
		} else {
			System.out.println(MSG_INORDER + "\n" + inOrderTraversal(bst));
		}
	}

	public void preOrder(Node bst) {
		if (bst == null) {
			System.out.println(MSG_ERROR_NULL);
		} else {
			System.out.println(MSG_PREORDER + "\n" + preOrderTraversal(bst));
		}
	}

	public void postOrder(Node bst) {
		if (bst == null) {
			System.out.println(MSG_ERROR_NULL);
		} else {
			System.out.println(MSG_POSTORDER + "\n" + postOrderTraversal(bst));
		}
	}

	public boolean areIdentical(final Node tree1, final Node tree2) {

		Node node1 = tree1;
		Node node2 = tree2;

		if (node1 != null && node2 != null) {
			boolean identical = node1.getData() == node2.getData();

			if (node1.getLeft() != null && node2.getLeft() != null) {
				identical = identical && areIdentical(node1.getLeft(), node2.getLeft());
			} else if (node1.getLeft() == null && node2.getLeft() == null) {
				identical = identical && true;
			} else {
				return false;
			}

			if (node2.getRight() != null && node2.getRight() != null) {
				identical = identical && areIdentical(node1.getRight(), node2.getRight());
			} else if (node1.getRight() == null && node2.getRight() == null) {
				identical = identical && true;
			} else {
				return false;
			}
			return identical;
		}
		return false;

	}

	public int height(Node root) {
		if (root == null) {
			return 0;
		}
		return (calculateHeight(root) - 1);
	}

	public <E> String levelOrder(final NodeGeneric<E> root) {

		if (root != null) {

			Queue<NodeGeneric<E>> queue = new Queue<>();
			StringBuilder stringBuilder = new StringBuilder();
			NodeGeneric<E> tempNode = root;

			while (tempNode != null) {
				stringBuilder.append(tempNode.getValue() + " - ");
				if (tempNode.getLeft() != null) {
					queue.enqueue(tempNode.getLeft());
				}
				if (tempNode.getRight() != null) {
					queue.enqueue(tempNode.getRight());
				}
				try {
					tempNode = queue.dequeue();
				} catch (QueueUnderflowException e) {
					e.printStackTrace();
					break;
				}
			}

			return stringBuilder.toString();
		}
		return null;
	}
	
	public <E> String inOrder(NodeGeneric<E> node) {
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" ( ");
		if (node != null) {
			if (node.getLeft() != null) {
				stringBuilder.append(inOrder(node.getLeft()));
			}
			stringBuilder.append(node.getValue());
			if (node.getRight() != null) {
				stringBuilder.append(inOrder(node.getRight()));
			}
		}
		stringBuilder.append(" ) ");
		return stringBuilder.toString();
	}

	private int calculateHeight(Node node) {

		int heightOfLeft = 1;
		int heightOfRight = 1;

		if (node.getLeft() != null) {
			heightOfLeft = heightOfLeft + calculateHeight(node.getLeft());
		}

		if (node.getRight() != null) {
			heightOfRight = heightOfRight + calculateHeight(node.getRight());
		}

		if (heightOfLeft > heightOfRight) {
			return heightOfLeft;
		} else {
			return heightOfRight;
		}

	}

	private String postOrderTraversal(Node node) {

		String res = "";

		if (node.getLeft() != null) {
			res += "[ ( " + postOrderTraversal(node.getLeft());
		}
		if (node.getRight() != null) {
			res += postOrderTraversal(node.getRight()) + " ) ";
		}
		res += node.getData() + " ]";
		return res;
	}

	private String preOrderTraversal(Node node) {

		String res = "" + node.getData() + " ";
		if (node.getLeft() != null) {
			res = "[ " + res + "( " + preOrderTraversal(node.getLeft());
		}
		if (node.getRight() != null) {
			res = res + preOrderTraversal(node.getRight()) + " ) ]";
		}

		return res;
	}

	public dsandalgos.linkedlists.singlylinkedlist.Node<Integer> toSinglyLinkedList(Node bst) {

		if (bst == null) {
			return null;
		} else {
			return convertToSinglyLinkedList(bst);
		}
	}

	public dsandalgos.linkedlists.doublylinkedlist.Node<Integer> toDoublyLinkedList(Node bst) {

		if (bst == null)
			return null;
		else {
			return convertToDoublyLinkedList(bst);
		}
	}

	private dsandalgos.linkedlists.doublylinkedlist.Node<Integer> convertToDoublyLinkedList(Node leaf) {

		dsandalgos.linkedlists.doublylinkedlist.Node<Integer> newNode = new dsandalgos.linkedlists.doublylinkedlist.Node<Integer>(
				null, null, leaf.getData());

		if (leaf.getLeft() != null) {
			dsandalgos.linkedlists.doublylinkedlist.Node<Integer> temp = convertToDoublyLinkedList(leaf.getLeft());
			// This while loop is needed to reach the end of the current LinkedList and set
			// the current Tree node as the next item on the list
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
			newNode.setPrevious(temp);
		}
		if (leaf.getRight() != null) {
			dsandalgos.linkedlists.doublylinkedlist.Node<Integer> temp = convertToDoublyLinkedList(leaf.getRight());
			// This while loop is needed to reach the beginning of the current LinkedList
			// and set it as the element after the current Tree node
			while (temp.getPrevious() != null) {
				temp = temp.getPrevious();
			}
			temp.setPrevious(newNode);
			newNode.setNext(temp);
		}

		dsandalgos.linkedlists.doublylinkedlist.Node<Integer> tempNode = newNode;
		while (tempNode.getPrevious() != null) {
			tempNode = tempNode.getPrevious();
		}
		newNode = tempNode;
		return newNode;
	}

	private dsandalgos.linkedlists.singlylinkedlist.Node<Integer> convertToSinglyLinkedList(Node leaf) {
		dsandalgos.linkedlists.singlylinkedlist.Node<Integer> newNode = null;
		if (leaf.getLeft() != null) {
			newNode = convertToSinglyLinkedList(leaf.getLeft());
		}
		if (newNode == null) {
			newNode = new dsandalgos.linkedlists.singlylinkedlist.Node<Integer>(null, leaf.getData());
		} else {
			dsandalgos.linkedlists.singlylinkedlist.Node<Integer> nd = newNode;
			// This while loop is needed to reach the end of the current LinkedList after
			// which the new node is to be added
			while (nd.getNext() != null) {
				nd = nd.getNext();
			}
			nd.setNext(new dsandalgos.linkedlists.singlylinkedlist.Node<Integer>(null, leaf.getData()));
		}
		if (leaf.getRight() != null) {
			dsandalgos.linkedlists.singlylinkedlist.Node<Integer> nd = newNode;
			// This while loop is needed to reach the end of the current LinkedList after
			// which the new node is to be added
			while (nd.getNext() != null) {
				nd = nd.getNext();
			}
			nd.setNext(convertToSinglyLinkedList(leaf.getRight()));
		}
		return newNode;
	}

	private String inOrderTraversal(Node node) {

		String res = " (";
		if (node.getLeft() != null) {
			res = res + inOrderTraversal(node.getLeft());
		}
		res = res + node.getData();
		if (node.getRight() != null) {
			res = res + inOrderTraversal(node.getRight());
		}
		return res = res + ") ";
	}

	private void traverseAndAdd(int item, Node node) {

		if (node.getData() > item) {
			if (node.getLeft() == null) {
				node.setLeft(new Node(item));
			} else {
				traverseAndAdd(item, node.getLeft());
			}
		} else if (node.getData() < item) {
			if (node.getRight() == null) {
				node.setRight(new Node(item));
			} else {
				traverseAndAdd(item, node.getRight());
			}
		}

	}

}
