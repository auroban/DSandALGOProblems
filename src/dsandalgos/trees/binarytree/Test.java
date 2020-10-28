package dsandalgos.trees.binarytree;

public class Test {

	public static void main(String[] args) {

		Integer[] intArray = { 30, 20, 10, 15, 50, 60, 75 };
		Node<Integer> rootInt = BinaryTreeUtil.getBinaryTree(intArray);
		System.out.println("\n\n************\nIN-ORDER\n*************\n\n");
		System.out.println(BinaryTreeUtil.inOrder(rootInt));
		System.out.println("\n\n************\nPRE-ORDER\n*************\n\n");
		System.out.println(BinaryTreeUtil.preOrder(rootInt));
		System.out.println("\n\n************\nPOST-ORDER\n*************\n\n");
		System.out.println(BinaryTreeUtil.postOrder(rootInt));
		System.out.println("\n\n************\nLEVEL-ORDER\n*************\n\n");
		System.out.println(BinaryTreeUtil.levelOrder(rootInt));

		String[] stringArray = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K" };
		Node<String> rootString = BinaryTreeUtil.getBinaryTree(stringArray);
		System.out.println("\n\n************\nIN-ORDER\n*************\n\n");
		System.out.println(BinaryTreeUtil.inOrder(rootString));
		System.out.println("\n\n************\nPRE-ORDER\n*************\n\n");
		System.out.println(BinaryTreeUtil.preOrder(rootString));
		System.out.println("\n\n************\nPOST-ORDER\n*************\n\n");
		System.out.println(BinaryTreeUtil.postOrder(rootString));
		System.out.println("\n\n************\nLEVEL-ORDER\n*************\n\n");
		System.out.println(BinaryTreeUtil.levelOrder(rootString));
	}

}
