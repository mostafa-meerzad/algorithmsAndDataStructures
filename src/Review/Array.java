package Review;
// todo
// create an array class:
// 1. that can accept the length of the array as an argument
// 2. the size of the array should be dynamic
// 3. add new elements to the array
// 4. remove elements from the array
// 5. print the array

public class Array {
    private int[] items;
    public Array(int length) {
        items = new int[length];
    }

    public void print(){
        for( int i = 0; i < items.length; i++){
            System.out.println(items[i]);
        }
    }
}
