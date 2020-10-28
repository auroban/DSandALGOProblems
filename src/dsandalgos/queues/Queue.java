package dsandalgos.queues;

import java.util.Arrays;

public class Queue<E> {
	
	private int head = 0;
	private int tail = 0;
	private static int DEFAULT_CAPACITY = 10;
	private Object[] elements;
	
	public Queue() {
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	public Queue(int capacity) {
		elements = new Object[capacity];
	}
	
	public void enqueue(E e) {
		
		if (head == tail) {
			head = tail = 0;
		}
		if (tail == elements.length) {
			elements = Arrays.copyOf(elements, (elements.length * 2));
		}
		elements[tail++] = e;
	}
	
	@SuppressWarnings("unchecked")
	public E dequeue() throws QueueUnderflowException {
		if (head == tail) {
			System.err.println("Empty Queue!!");
			throw new QueueUnderflowException();			
		}
		E e = (E) elements[head];
		elements[head++] = null;
		return e;
	}
	
	@SuppressWarnings("unchecked")
	public E getFirstElement() {
		return (E) elements[head];
	}
	
	@SuppressWarnings("unchecked")
	public E getLastElement() {
		return (E) elements[tail-1];
	}
	
	public boolean isQueueEmpty() {
		return head == tail;
	}

}
