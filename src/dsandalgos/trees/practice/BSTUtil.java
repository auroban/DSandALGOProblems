package dsandalgos.trees.practice;

import dsandalgos.trees.Node;

public class BSTUtil {
	
	
	public static void main(String[] args) {
		
		Node nodeLevel3Left = new Node(2);
		Node nodeLevel3Right = new Node(6);
		Node nodeLevel2Left = new Node(5);
		nodeLevel2Left.setLeft(nodeLevel3Left);
		nodeLevel2Left.setRight(nodeLevel3Right);
		
		
		Node nodeLevel3LeftR = new Node(13);
		Node nodeLevel3RightR = new Node(18);
		Node nodeLevel2Right = new Node(15);
		nodeLevel2Right.setLeft(nodeLevel3LeftR);
		nodeLevel2Right.setRight(nodeLevel3RightR);
		
		Node nodeLevel1Left = new Node(10);
		nodeLevel1Left.setLeft(nodeLevel2Left);
		nodeLevel1Left.setRight(nodeLevel2Right);
		
		
		Node n1 = new Node(32);
		Node n2 = new Node(35);
		n2.setLeft(n1);
		
		Node n3 = new Node(25);
		Node n4 = new Node(30);
		n4.setLeft(n3);
		n4.setRight(n2);
		
		Node rootNode = new Node(20);
		rootNode.setLeft(nodeLevel1Left);
		rootNode.setRight(n4);
		
		
		System.out.println("This is IN-ORDER:\n");
		System.out.println(inOrderTraversal(rootNode));
		
		System.out.println("This is PRE-ORDER:\n");
		System.out.println(preOrderTraversal(rootNode));
		
		System.out.println("This is POST-ORDER:\n");
		System.out.println(postOrderTraversal(rootNode));
		
		
	}

	public static Node getBinarySearchTree(final int[] arr) {

		if (arr == null || arr.length == 0) {
			return null;
		}

		Node node = null;
		for (int item : arr) {
			insert(node, item);
		}

		return node;
	}

	private static void insert(Node node, int value) {

		if (node == null) {
			Node newNode = new Node(value);
			newNode.setLeft(null);
			newNode.setRight(null);
			node = newNode;
		} else {
			int nodeValue = node.getData();

			if (nodeValue < value) {
				insert(node.getLeft(), value);
			}

			if (nodeValue > value) {
				insert(node.getRight(), value);
			}
		}
	}

	public static String inOrderTraversal(Node rootNode) {
		if (rootNode == null) {
			return null;
		}
		return inOrder(rootNode);
	}

	public static String preOrderTraversal(Node rootNode) {
		if (rootNode == null) {
			return null;
		}
		return preOrder(rootNode);
	}

	public static String postOrderTraversal(Node rootNode) {
		if (rootNode == null) {
			return null;
		}
		return postOrder(rootNode);
	}

	private static String inOrder(Node node) {

		StringBuilder stringBuilder = new StringBuilder();
		if (node.getLeft() != null) {
			stringBuilder.append(inOrderTraversal(node.getLeft()));
		}

		stringBuilder.append(node.getData());

		if (node.getRight() != null) {
			stringBuilder.append(inOrderTraversal(node.getRight()));
		}
		return stringBuilder.toString();
	}

	private static String preOrder(Node node) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(node.getData());

		if (node.getLeft() != null) {
			stringBuilder.append(preOrder(node.getLeft()));
		}

		if (node.getRight() != null) {
			stringBuilder.append(preOrder(node.getRight()));
		}

		return stringBuilder.toString();
	}

	private static String postOrder(Node node) {

		StringBuilder stringBuilder = new StringBuilder();

		if (node.getLeft() != null) {
			stringBuilder.append(postOrder(node.getLeft()));
		}

		if (node.getRight() != null) {
			stringBuilder.append(postOrder(node.getRight()));
		}

		stringBuilder.append(node.getData());

		return stringBuilder.toString();
	}
}
