import java.util.*;

public class MapIterationDemo {
    public static void main(String[] args) {

        Map<String, Integer> population = new HashMap<>();

        population.put("India", 1400000000);
        population.put("China", 1450000000);
        population.put("USA", 330000000);
        population.put("Brazil", 215000000);
        population.put("Russia", 145000000);

        // 1. entrySet() - RECOMMENDED (most efficient)
        System.out.println("---- 1. entrySet() ----");
        for (Map.Entry<String, Integer> entry : population.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 2. keySet() + get() (two lookups)
        System.out.println("\n---- 2. keySet() ----");
        for (String country : population.keySet()) {
            System.out.println(country + " : " + population.get(country));
        }

        // 3. values() only (no keys)
        System.out.println("\n---- 3. values() ----");
        long total = 0;

        for (int pop : population.values()) {
            total += pop;
        }

        System.out.println("World total: " + total);

        // 4. forEach (Java 8 lambda)
        System.out.println("\n---- 4. forEach ----");
        population.forEach((country, pop) -> {
            System.out.printf("%-10s %d%n", country, pop);
        });

        // 5. Stream + entrySet - filter and sort
        // Countries with population > 300 million, sorted descending
        System.out.println(
                "\n---- 5. Stream - countries pop > 300 million ----");

        population.entrySet()
                .stream()
                .filter(e -> e.getValue() > 300_000_000)
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e ->
                        System.out.println(e.getKey() + " : " + e.getValue()));

        /*
         Output:
         China : 1450000000
         India : 1400000000
         USA   : 330000000
         */

        // 6. Modifying values while iterating
        // Count visitors; add bonus visits with entrySet
        Map<String, Integer> visits = new HashMap<>();

        visits.put("Page1", 100);
        visits.put("Page2", 200);
        visits.put("Page3", 50);

        for (Map.Entry<String, Integer> e : visits.entrySet()) {
            e.setValue(e.getValue() + 10); // add 10 to each
        }

        System.out.println(visits);
        // {Page1=110, Page2=210, Page3=60}
    }
}