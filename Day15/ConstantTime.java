import java.util.HashMap;

public class ConstantTime {
    public static void main(String[] args) {

        // Real-life: Accessing a locker by number
        // You know locker #42 — go directly, no searching

        int[] lockers = {10, 20, 30, 40, 50};
        int value = lockers[2]; // O(1) — direct index access

        System.out.println("Value at index 2: " + value);

        // Another O(1) example: HashMap.get()

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alice", 95);

        int score = map.get("Alice"); // O(1) average

        System.out.println("Alice's score: " + score);
    }
}