package dsandalgos.trees.problems.printleafnodes;

import dsandalgos.trees.BinarySearchTreeUtils;
import dsandalgos.trees.Node;

class Test {

	public static void main(String[] args) {

		Test test = new Test();
		final int[] items = { 10, 8, 12, 7, 9, 11, 15, 13, 16 };
		Node node = null;
		for (int item : items) {
			node = test.insert(node, item);
			System.out.println(" /*/*/*/*/*/*/*/*/*/*/ ");
		}
		
		BinarySearchTreeUtils.getInstance().inOrder(node);
		test.printLeafNodes(node);
	}

	Node insert(Node root, int value) {
		System.out.println("Coming with the Value: " + value);
		if (root == null) {
			System.out.println("Assigning: " + value);
			root = new Node(value);
		} else if (value < root.getData()) {
			if (root.getLeft() == null) {
				root.setLeft(new Node(value));
			} else {
				insert(root.getLeft(), value);
			}
		} else if (value > root.getData()) {
			if (root.getRight() == null) {
				root.setRight(new Node(value));
			} else {
				insert(root.getRight(), value);
			}
		}
		return root;
	}

	void printLeafNodes(Node node) {

		if (node != null) {
			if (node.getLeft() == null && node.getRight() == null) {
				System.out.println(node.getData());
			}

			if (node.getLeft() != null) {
				printLeafNodes(node.getLeft());
			}

			if (node.getRight() != null) {
				printLeafNodes(node.getRight());
			}
		}
	}

}
