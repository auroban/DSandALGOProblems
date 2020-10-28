package dsandalgos.trees.problems.linknodesonsamelevel;


class Test {

	public static void main(String[] args) {
		final String[] strings = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
		Node<String> rootNode = TreeUtil.getBinaryTree(strings);
		System.out.println(TreeUtil.inOrder(rootNode));
		System.out.println("\n\n***********\n\n");
		System.out.println(TreeUtil.levelOrder(rootNode));
		TreeUtil.linkNodes(rootNode);
		System.out.println("\n\n");
		System.out.println(rootNode.getLeft().getLeft().getLeft().getNext().getNext());
		
	}

}
