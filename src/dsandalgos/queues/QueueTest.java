package dsandalgos.queues;

public class QueueTest {

	public static void main(String[] args) {
		
		Queue<String> queue = new Queue<>(5);
		queue.enqueue("Auro");
		queue.enqueue("Ban");
		queue.enqueue("Ari");
		queue.enqueue("Arijit");
		queue.enqueue("Banerjee");
		try {
			System.out.println("Popped Item:\t" + queue.dequeue());
		} catch (QueueUnderflowException e) {
			e.printStackTrace();
		}
		System.out.println("First:\t" + queue.getFirstElement());
		System.out.println("Last:\t" + queue.getLastElement());
		System.out.println("Queue is:\t" + queue.isQueueEmpty());
		try {
			System.out.println("Popped Item:\t" + queue.dequeue());
			System.out.println("Popped Item:\t" + queue.dequeue());
			System.out.println("Popped Item:\t" + queue.dequeue());
			System.out.println("Popped Item:\t" + queue.dequeue());
			System.out.println("Popped Item:\t" + queue.dequeue());
			System.out.println("Popped Item:\t" + queue.dequeue());
		} catch (QueueUnderflowException e) {
			e.printStackTrace();
		}
		System.out.println("Queue is:\t" + queue.isQueueEmpty());		
	}

}
