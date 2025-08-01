package HashTable;

public class main {
    public static void main(String[] args) {
        CharFinder chFinder = new CharFinder();
        var firstMin = chFinder.findFirstNonRepeatingChar("a green apply");
        System.out.println(firstMin);
    }
}
