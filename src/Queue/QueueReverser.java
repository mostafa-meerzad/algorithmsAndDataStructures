package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    Queue<Integer> queue = new LinkedList<>();

    QueueReverser() {
    }

    public void enqueue(int item) {
        queue.add(item);
    }

    public int dequeue() {
        return queue.remove();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int peek() {
        return queue.peek();
    }

    public void reverse(int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for(int i = 0; i < queue.size() - k; i++){
            queue.add(queue.remove());
        }


//        return queue;

    }

    public String print() {
        return queue.toString();
    }
}
