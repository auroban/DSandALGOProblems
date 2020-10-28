package dsandalgos.stacks;

import java.util.Arrays;

public class StackWithDynamicCapacity<E> {
	
	private int top = -1;
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elements;
	
	public StackWithDynamicCapacity() {
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	public StackWithDynamicCapacity(int capacity) {
		elements = new Object[capacity];
	}
	
	public void push(E e) {
		
		if (++top == elements.length) {
			elements = Arrays.copyOf(elements, (elements.length * 2));
		}
		elements[top] = e;
	}
	
	@SuppressWarnings("unchecked")
	public E pop() throws StackUnderflowException {
		if (top == -1) {
			throw new StackUnderflowException();
		}
		E e = (E) elements[top];
		elements[top--] = null;
		return e;
	}
	
	public boolean isStackEmpty() {
		return top == -1;
	}
	

}
