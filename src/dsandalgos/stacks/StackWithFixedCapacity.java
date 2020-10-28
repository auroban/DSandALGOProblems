package dsandalgos.stacks;

public class StackWithFixedCapacity<E> {
	
	private int top = -1;
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elements;
	
	public StackWithFixedCapacity() {
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	public StackWithFixedCapacity(int capacity) {
		elements = new Object[capacity];
	}
	
	public void push(E e) throws StackOverFlowException {
		if (++top == elements.length) {
			throw new StackOverFlowException();
		}
		elements[top] = e;
	}
	
	public E pop() throws StackUnderflowException {
		
		if (top == -1) {
			throw new StackUnderflowException();
		}
		@SuppressWarnings("unchecked")
		E e = (E) elements[top];
		elements[top--] = null;
		return e;
	}
	
	public boolean isStackEmpty() {
		return top == -1;
	}

}
