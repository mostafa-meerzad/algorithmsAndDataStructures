package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
/*
initial
q1 =>                          [10]                 [20, 10]
q2 => [10]                     []-> [20]            [] -> [30]

move all items from q1 to q2
q1 =>                          [10] -> []           [20, 10] -> []
q2 => [10]                     [20] -> [20, 10]     [30] -> [30, 20, 10]

swap q1 and q2
q1 => [10]                     [] -> [20, 10]       [] -> [30, 20, 10]
q2 =>                          [20, 10] -> []       [30, 20, 10] -> []

push(10)
push(20)
push(30)

 */
    public void push(int item){
        // add item to q2
        q2.add(item);
        // move all items from q1 to q2
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        // swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

    }

    public int pop(){
        if(q1.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return q1.remove();
    }

    public int peek(){
        if(q1.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return q1.peek();
    }
    public boolean isEmpty(){
        return q1.isEmpty();
    }
    public int size(){
        return q1.size();
    }
    @Override
    public String toString(){
        return q1.toString();
    }
}
