import java.util.Arrays;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        if (count == items.length) {
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count++] = item;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;
        return -1;

    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public int max() {
        int max = items[0];
        for (int i = 0; i < count; i++) {
            if (items[i] > max)
                max = items[i];
        }
        return max;
    }

    public int[] intersect(Array another) {
        int commonsCount = Math.min(count, another.count);
        int[] commons = new int[commonsCount];
        int commonsIndex = 0;

        for (int i = 0; i < another.count; i++) {
            for (int j = 0; j < count; j++) {
                if (another.items[i] == items[j]) {
                    commons[commonsIndex++] = items[j];
                    break;
                }
            }
        }
        return Arrays.copyOf(commons, commonsIndex);

    }

    public Array reverse() {
        Array reverse = new Array(count);
        for (int i = count - 1; i > -1; i--) {
            reverse.insert(items[i]);
        }

        return reverse;

    }

    public String printArray() {
        int[] arrayItems = new int[count];
        for (int i = 0; i < count; i++)
            arrayItems[i] = items[i];
        return Arrays.toString(arrayItems);
    }


}