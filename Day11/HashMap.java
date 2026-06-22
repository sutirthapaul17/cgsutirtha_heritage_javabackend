import java.util.*;


public class HashMap {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

// ── put(key, value) ───────────────────────────
        scores.put("Alice",  95);
        scores.put("Bob",    82);
        scores.put("Charlie",91);
        scores.put("Diana",  78);
        System.out.println(scores);
// {Bob=82, Alice=95, Diana=78, Charlie=91}  (order NOT guaranteed)

// put() returns OLD value (or null if new key)
        Integer old = scores.put("Alice", 99);  // update Alice
        System.out.println("Old: " + old);  // Old: 95
        System.out.println("New: " + scores.get("Alice"));  // New: 99

// ── get(key) ──────────────────────────────────
        System.out.println(scores.get("Bob"));    // 82
        System.out.println(scores.get("Zara"));   // null (key doesn't exist)

// getOrDefault – safe get with fallback
        int s = scores.getOrDefault("Zara", 0);
        System.out.println(s);  // 0 (instead of null)

// ── containsKey() / containsValue() ──────────
        System.out.println(scores.containsKey("Bob"));    // true
        System.out.println(scores.containsKey("Eve"));    // false
        System.out.println(scores.containsValue(82));     // true

// ── remove(key) ───────────────────────────────
        scores.remove("Diana");
        System.out.println(scores.containsKey("Diana")); // false

// ── size() ────────────────────────────────────
        System.out.println(scores.size());  // 3

// ── keySet() / values() / entrySet() ──────────
        System.out.println(scores.keySet());   // [Bob, Alice, Charlie]
        System.out.println(scores.values());   // [82, 99, 91]

    }
}
