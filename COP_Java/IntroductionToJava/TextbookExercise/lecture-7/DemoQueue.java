
public class DemoQueue {

	public static void main(String[] args) {
        Queue queue = new Queue();

        // Enqueue elements into the queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // Print the queue
        System.out.println("Queue elements after enqueues:");
        queue.printQueue();

        // Peek the front element
        System.out.println("Front element is: " + queue.peek());

        // Dequeue elements from the queue
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());

        // Print the queue again after dequeuing
        System.out.println("Queue elements after dequeues:");
        queue.printQueue();

        // Peek again after dequeuing
        System.out.println("Front element after dequeuing is: " + queue.peek());

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());

        // Check the size of the queue
        System.out.println("Current size of queue: " + queue.size());
    }
}
