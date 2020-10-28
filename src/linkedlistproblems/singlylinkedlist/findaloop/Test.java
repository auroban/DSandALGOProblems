package linkedlistproblems.singlylinkedlist.findaloop;

class Test {

	public static void main(String[] args) {
		
		Node node1 = new Node(10);
		Node node2 = new Node(20);
		Node node3 = new Node(30);
		Node node4 = new Node(40);
		Node node5 = new Node(50);
		Node node6 = new Node(60);
		
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node3);
		
		
		Node headNode = node1;
		
		System.out.println(LinkedListUtils.getStringRepresentation(headNode));
		System.out.println("Has a Loop? " + LinkedListUtils.hasALoop(headNode));
		headNode = LinkedListUtils.detectAndEliminateLoop(headNode);
		System.out.println(LinkedListUtils.getStringRepresentation(headNode));

	}

}
