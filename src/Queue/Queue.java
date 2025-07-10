package Queue;

public class Queue {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();

//        queue.enqueue(10);
//        queue.enqueue(20);
//        queue.enqueue(30);
//        queue.enqueue(40);
//        queue.enqueue(50);
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        queue.enqueue(70);
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        queue.dequeue();

//        System.out.println("size of queue: " + queue.size());
//        System.out.println(queue.toString());
//        System.out.println("just removed: " + queue.dequeue());
//        System.out.println("size of queue: " + queue.size());
//        System.out.println(4%5);

//        ----------------------------------- stack queue-----------------------
        StackQueue stackQueue = new StackQueue();
        stackQueue.enqueue(10);
        stackQueue.enqueue(20);
        stackQueue.enqueue(30);
        System.out.println(stackQueue.dequeue());
        System.out.println(stackQueue.dequeue());
        stackQueue.enqueue(40);
        System.out.println(stackQueue.dequeue());
        System.out.println(stackQueue.dequeue());
        System.out.println(stackQueue.dequeue());


    }
}
