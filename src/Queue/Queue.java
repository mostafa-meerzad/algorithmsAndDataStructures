package Queue;

public class Queue {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(70);

        System.out.println("size of queue: " + queue.size());
        System.out.println("just removed: " + queue.dequeue());
        System.out.println("size of queue: " + queue.size());

    }
}
