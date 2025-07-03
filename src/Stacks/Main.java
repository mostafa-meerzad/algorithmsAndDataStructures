package Stacks;

public class Main {
    public static void main(String[] args) {
//
//        Stack<Integer> stack = new Stack<>();
//        stack.add(10);
//        stack.add(20);
//        stack.add(30);
//        System.out.println(stack);
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack);

//        String str = "abc";
//        StringReverser reverser = new StringReverser();
//        String result = reverser.reverser(null);
//        System.out.println(result);

//        String str = "(som{eth})ing";
//        Boolean balanced = new BalancedExpression().isBalanced(str);
//        System.out.println(balanced);

//        --------------------------
//        String str = "(a<bc>{()})";
//        Expression exp = new Expression();
//        boolean result = exp.isBalanced(str);
//        System.out.println(result);

        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
        System.out.println(stack.size());
        System.out.println(stack.toString());




    }
}
