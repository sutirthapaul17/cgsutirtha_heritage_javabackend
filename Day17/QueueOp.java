import java.util.ArrayDeque;

class QueueUsingDeque {

    private ArrayDeque<Integer> queue;
    public QueueUsingDeque() {
        queue = new ArrayDeque<>();
    }
    public void enqueue(int value) {
        queue.offer(value);
        System.out.println(value + " enqueued into the queue.");
    }
    public int dequeue() {

        if (isEmpty()) {
            throw new IllegalStateException(
                    "Queue Underflow! Cannot dequeue from an empty queue.");
        }
        return queue.poll();
    }
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException(
                    "Queue is empty. No front element.");
        }
        return queue.peek();
    }
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    public void display() {
        System.out.println("Queue: " + queue);
    }
}

public class QueueOp {

    public static void main(String[] args) {
        QueueUsingDeque queue = new QueueUsingDeque();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        System.out.println("Front Element: " + queue.peek());
        System.out.println("Dequeued Element: " + queue.dequeue());
        queue.display();
        System.out.println("Is Queue Empty? " + queue.isEmpty());

        queue.dequeue();
        queue.dequeue();

        System.out.println("Is Queue Empty? " + queue.isEmpty());
        try {
            queue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}