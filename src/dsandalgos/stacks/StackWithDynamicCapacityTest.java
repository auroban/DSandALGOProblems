package dsandalgos.stacks;

public class StackWithDynamicCapacityTest {

	public static void main(String[] args) {
		
		StackWithDynamicCapacity<Integer> stack = new StackWithDynamicCapacity<>();
		stack.push(null);
		try {
			System.out.println("Popped item is:\t" + stack.pop());
		} catch (StackUnderflowException e) {
			e.printStackTrace();
		}
	}

}
