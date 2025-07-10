package Queue;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public StackQueue() {}

    public void enqueue(int item){
        inStack.push(item);
    }

    public int dequeue(){
        putStack1intoStack2();
        return outStack.pop();
    }
    public int peek(){
        putStack1intoStack2();
        return outStack.peek();
    }

    private void putStack1intoStack2() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if(outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }
    public boolean isEmpty(){
        return inStack.isEmpty() && outStack.isEmpty();
    }


}
