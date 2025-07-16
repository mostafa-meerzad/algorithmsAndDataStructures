package Queue;

public class PriorityQueue {
    private int[] data;
    private int size;

    public PriorityQueue(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public void enqueue(int item) {

        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }

        int i = size - 1;

        while (i >= 0 && data[i]< item) {
            data[i + 1] = data[i];
            i--;
        }
        data[i + 1] = item;
        size++;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }

        return data[--size];
    }
    public int peek(){
        if(size == 0){
            throw new IllegalStateException("Queue is empty");
        }
        return data[size - 1];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
}
