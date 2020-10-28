package dsandalgos.queues;

public class QueueUnderflowException extends Exception {
	
	private static final long serialVersionUID = 32568L;
	public QueueUnderflowException() {
		super("Stack Underflowed!!");
	}

}
