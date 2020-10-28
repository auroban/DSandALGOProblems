package dsandalgos.trees.problems.levelorder;

import java.util.Arrays;

import dsandalgos.trees.BinarySearchTreeUtils;
import dsandalgos.trees.NodeGeneric;

class Test {

	public static void main(String[] args) {

		final Integer[] array = { 40, 50, 60, 200, 100, 10, 90, 80 };
		BinarySearchTreeUtils bstUtils = BinarySearchTreeUtils.getInstance();
		
		NodeGeneric<Integer> tree = bstUtils.getBinaryTree(Arrays.asList(array));
		System.out.println(tree.getValue());
		System.out.println(bstUtils.inOrder(tree));
		System.out.println(bstUtils.levelOrder(tree));

	}

}
