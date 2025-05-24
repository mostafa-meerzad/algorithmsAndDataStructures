package Review;
// todo
// create an array class:
// 1. that can accept the length of the array as an argument ✅
// 2. the size of the array should be dynamic
// 3. add new elements to the array
// 4. remove elements from the array
// 5. print each element of the array ✅

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void print(){
        for( int i = 0; i < count; i++){
            System.out.println(items[i]);
        }
    }
}
