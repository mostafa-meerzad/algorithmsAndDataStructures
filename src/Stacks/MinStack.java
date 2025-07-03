package Stacks;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {}

    public void push(int item) {
        stack.push(item);
        if(minStack.isEmpty() || item <= minStack.peek()){
            minStack.push(item);
        }
    }

    public int pop() {
        int item = stack.pop();
        if(item == minStack.peek()){
            minStack.pop();
        }
        return item;
    }

    public int min() {
        if(minStack.isEmpty()){
            throw new IllegalArgumentException( "The stack is empty");
        }
        return minStack.peek();
    }
}
