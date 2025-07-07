package Queue;

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
        queue[rear++] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        size--;
        return queue[front++];
    }

    public int peek() {
        return queue[front];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public int size() {
        return size;
    }

}
