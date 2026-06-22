import java.util.*;

public class LinkedHashMapDemo {
    public static void main(String[] args) {

        LinkedHashMap<String, Integer> menu = new LinkedHashMap<>();

        menu.put("Burger", 120);
        menu.put("Pizza", 250);
        menu.put("Pasta", 180);
        menu.put("Salad", 90);
        menu.put("Juice", 60);

        // Iterates in insertion order
        System.out.println("---- Restaurant Menu ----");

        for (Map.Entry<String, Integer> e : menu.entrySet()) {
            System.out.printf("%-10s Rs.%d%n", e.getKey(), e.getValue());
        }

        /*
         OUTPUT (always in insertion order):
         Burger     Rs.120
         Pizza      Rs.250
         Pasta      Rs.180
         Salad      Rs.90
         Juice      Rs.60
         */

        // LRU Cache using LinkedHashMap
        // Override removeEldestEntry() to create a fixed-size LRU cache

        LinkedHashMap<Integer, String> lruCache =
                new LinkedHashMap<Integer, String>(16, 0.75f, true) {

                    @Override
                    protected boolean removeEldestEntry(
                            Map.Entry<Integer, String> eldest) {
                        return size() > 3; // keep max 3 entries
                    }
                };

        lruCache.put(1, "Page1");
        lruCache.put(2, "Page2");
        lruCache.put(3, "Page3");

        lruCache.get(1); // access Page1 -> moves it to end (most recently used)

        lruCache.put(4, "Page4");
        // adds Page4 -> evicts least recently used (Page2)

        System.out.println(lruCache);
        // {3=Page3, 1=Page1, 4=Page4}
    }
}