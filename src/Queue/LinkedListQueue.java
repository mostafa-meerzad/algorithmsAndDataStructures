package Queue;

public class LinkedListQueue {
    private LinkedList list = new LinkedList();

    public void enqueue(int item) {
        list.addLast(item);
    }

    public int dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        } else {
            return list.removeFirst();
        }
    }

    public int peek() {
        return list.peek();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
