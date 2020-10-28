package dsandalgos.stacks;

public class StackOverFlowException extends Exception {
	
	private static final long serialVersionUID = 4265487L;
	public StackOverFlowException() {
		super("Stack limit exceeded!!");
	}
}
