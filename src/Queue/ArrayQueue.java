package Queue;

import java.util.Arrays;

public class ArrayQueue {
    private int[] queue = new int[5];
    private int front;
    private int rear;
    private int size;

    public ArrayQueue() {
    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalArgumentException("Queue is full");
        }
        queue[rear] = item;
        rear = (rear + 1) % queue.length;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        var item = queue[front];
        queue[front] = 0;
        front = (front + 1) % queue.length;
        size--;
        return item;
    }

    public int peek() {
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public int size() {
        return size;
    }
    @Override
    public String toString(){
        return Arrays.toString(queue);
    }

}
