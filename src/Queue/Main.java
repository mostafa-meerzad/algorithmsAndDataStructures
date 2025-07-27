package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        Queue<Integer> queue = new ArrayDeque<>();

//        queue.add(10);
//        queue.add(20);
//        queue.add(30);
//        System.out.println("Queue after adding elements: " + queue);
//        queue.remove();
//        System.out.println("Queue after removing an element: " + queue);
//        System.out.println(queue.peek());
//        queue.poll();
//        queue.poll();
//        queue.remove();
//        System.out.println("Queue after removing an element: " + queue);

//        reverse(queue);
//        System.out.println("Reversed queue: " + queue);

        //-------------------- priority queue -------------------------
//        PriorityQueue pq = new PriorityQueue(5);
//        pq.enqueue(5);
//        pq.enqueue(2);
//        pq.enqueue(4);
//        pq.enqueue(1);

//        while(!pq.isEmpty()){
//            System.out.println(pq.dequeue());
//        }
//        System.out.println(pq.dequeue());
//        System.out.println(pq.dequeue());

// ----------------------  queue reverser  ---------------------

//        QueueReverser reverseQueue = new QueueReverser();
//        reverseQueue.enqueue(10);
//        reverseQueue.enqueue(20);
//        reverseQueue.enqueue(30);
//        reverseQueue.enqueue(40);
//        reverseQueue.enqueue(50);
//        reverseQueue.reverse(3);
////        System.out.println(reverseQueue.reverse(3));
//        System.out.println(reverseQueue.print());

//        --------------------- linkedList Queue ----------------

        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.size());

    }
    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty()){
            stack.add(queue.remove());
        }

        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }

    }

}
