package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Queue after adding elements: " + queue);
        queue.remove();
        System.out.println("Queue after removing an element: " + queue);
        System.out.println(queue.peek());
        queue.poll();
        queue.poll();
        queue.remove();
        System.out.println("Queue after removing an element: " + queue);


    }
}
