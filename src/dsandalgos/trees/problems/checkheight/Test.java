package dsandalgos.trees.problems.checkheight;

import dsandalgos.trees.BinarySearchTreeUtils;
import dsandalgos.trees.Node;

class Test {

	public static void main(String[] args) {
		
		Node c1n1 = new Node(5);
		Node c1n2 = new Node(15);
		Node c1n3 = new Node(10);
		c1n3.setLeft(c1n1);
		c1n3.setRight(c1n2);
		
		
		Node c1n4 = new Node(45);
		Node c1n5 = new Node(50);
		c1n5.setLeft(c1n4);
		
		Node c1n6 = new Node(35);
		Node c1n7 = new Node(40);
		
		c1n7.setLeft(c1n6);
		c1n7.setRight(c1n5);
		
		
		Node c1n8 = new Node(25);
		Node c1n9 = new Node(30);
		
		c1n9.setLeft(c1n8);
		c1n9.setRight(c1n7);
		
		Node root = new Node(20);
		root.setLeft(c1n3);
		root.setRight(c1n9);
		
		Test test = new Test();
		System.out.println(test.height(root));
		
		
		Node c2 = new Node(10);
		System.out.println("\n\n" + test.height(c2));
		
		Node c3n1 = new Node(20);
		Node c3n2 = new Node(15);
		Node c3n3 = new Node(25);
		
		c3n1.setLeft(c3n2);
		c3n1.setRight(c3n3);
		
		System.out.println("\n\n" + test.height(c3n1));

		System.out.println("\n\n******************\n\n");
		System.out.println(BinarySearchTreeUtils.getInstance().height(root));
	}
	
	
	int height(Node root) {
		if (root == null) {
			return 0;
		}
		return (calculateHeight(root) - 1);
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

}
