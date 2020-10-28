package dsandalgos.trees.problems.leftview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import dsandalgos.trees.BinarySearchTreeUtils;
import dsandalgos.trees.Node;

public class LeftView {

	public String getLeftView(final Node root) {
		if (root == null) {
			return null;
		}

		HashSet<Node> nodeHashSet = new HashSet<>();
		HashSet<Integer> levelHashSet = new HashSet<>();

		getLeftView(root, 0, levelHashSet, nodeHashSet);

		StringBuilder stringBuilder = new StringBuilder();
		if (nodeHashSet.size() > 0) {
			nodeHashSet.stream().forEach((node) -> {
				stringBuilder.append(node.getData());
				stringBuilder.append(" -- ");
			});
		}
		return stringBuilder.toString();
	}

	private void getLeftView(final Node node, final Integer level, final HashSet<Integer> levelHashSet,
			final HashSet<Node> nodeHashSet) {

		if (!levelHashSet.contains(level)) {
			nodeHashSet.add(node);
			levelHashSet.add(level);
		}

		if (node.getLeft() != null) {
			getLeftView(node.getLeft(), level + 1, levelHashSet, nodeHashSet);
		}

		if (node.getRight() != null) {
			getLeftView(node.getRight(), level + 1, levelHashSet, nodeHashSet);
		}
	}

	public static void main(String[] args) {
		final Integer[] array = { 4, 5, 2, 3, 1, 6, 7 };
		final ArrayList<Integer> list = new ArrayList<>();
		
		for (Integer item : array) {
			list.add(item);
		}
		BinarySearchTreeUtils bstUtils = BinarySearchTreeUtils.getInstance();
		Node root = bstUtils.getBinarySearchTree(list);
		
		
		bstUtils.preOrder(root);
		
		
		System.out.println("AFTER");
		
		LeftView leftView = new LeftView();
		String leftViewString = leftView.getLeftView(root);
		
		System.out.println("LEFT VIEW:\n" + leftViewString);
	}

}
