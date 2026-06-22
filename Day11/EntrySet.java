import java.util.Map;

public class EntrySet {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95); scores.put("Bob", 82); scores.put("Charlie", 91);

// ── Method 1: entrySet() with Map.Entry ───────
        System.out.println("--- entrySet() ---");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

// ── Method 2: keySet() then get() (less efficient) ──
        System.out.println("--- keySet() ---");
        for (String key : scores.keySet()) {
            System.out.println(key + ": " + scores.get(key));
        }

// ── Method 3: forEach lambda (Java 8+) ─────────
        System.out.println("--- forEach ---");
        scores.forEach((name, score) -> {
            System.out.println(name + " scored " + score);
        });

// ── putIfAbsent() – only add if key not present ─
        scores.putIfAbsent("Alice", 50);  // Alice exists, no change
        scores.putIfAbsent("Eve",   88);  // Eve new, added
        System.out.println(scores.get("Alice")); // 95 (unchanged)
        System.out.println(scores.get("Eve"));   // 88

// ── merge() – combine existing and new value ───
        scores.merge("Alice", 5, Integer::sum);  // 95 + 5 = 100
        System.out.println(scores.get("Alice")); // 100

// ── compute() ──────────────────────────────────
        scores.compute("Bob", (k, v) -> v == null ? 0 : v + 10);
        System.out.println(scores.get("Bob"));  // 92

    }
}
