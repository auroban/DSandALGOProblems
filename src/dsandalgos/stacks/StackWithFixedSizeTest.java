package dsandalgos.stacks;

public class StackWithFixedSizeTest {

	public static void main(String[] args) {
		
		StackWithFixedCapacity<String> stack = new StackWithFixedCapacity<String>(3);
		System.out.println("Is Stack Empty:\t" + stack.isStackEmpty() + "\n\n");
		
		
		try {
			stack.push("Whaddup??");
			stack.push("Waz happening?");
			stack.push("How ya doing?");
			stack.push("Gonna be an overflow");
			System.out.println("Stack Pop:\t" + stack.pop() + "\n\n");
			System.out.println("Is Stack Empty:\t" + stack.isStackEmpty() + "\n\n");
		} catch (StackOverFlowException | StackUnderflowException e) {
			e.printStackTrace();
		}
	}

}
