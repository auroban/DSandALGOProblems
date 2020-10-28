package dsandalgos.stacks;

public class StackUnderflowException extends Exception {

	private static final long serialVersionUID = 4598756L;
	
	public StackUnderflowException() {
		super("Empty stack. Stack limit: -1;");
	}
}
