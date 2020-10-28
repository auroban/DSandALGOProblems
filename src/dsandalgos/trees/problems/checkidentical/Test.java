package dsandalgos.trees.problems.checkidentical;

import java.util.Arrays;

import dsandalgos.trees.BinarySearchTreeUtils;
import dsandalgos.trees.Node;

class Test {

	public static void main(String[] args) {

		final Integer[] array = { 20, 10, 30, 5, 15, 25, 35, 2, 6, 13, 18, 32 };
		final Integer[] array2 = { 20, 10, 30, 0, 15, 25, 35, 2, 6, 13, 18, 32 };
		Node tree1 = BinarySearchTreeUtils.getInstance().getBinarySearchTree(Arrays.asList(array));
		Node tree2 = BinarySearchTreeUtils.getInstance().getBinarySearchTree(Arrays.asList(array2));
		
		BinarySearchTreeUtils.getInstance().inOrder(tree1);
		BinarySearchTreeUtils.getInstance().inOrder(tree2);
		System.out.println("\n\n" + areIdentical(tree1, tree2));
		System.out.println("\n\n\n****************\n");
		System.out.println(BinarySearchTreeUtils.getInstance().areIdentical(tree1, tree2));
	}
	
	private static boolean areIdentical(Node node1, Node node2) {
		
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

}
