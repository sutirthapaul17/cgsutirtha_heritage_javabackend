import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();

        // add() - returns true if new, false if duplicate
        System.out.println(set.add("Java"));      // true
        System.out.println(set.add("Python"));    // true
        System.out.println(set.add("Java"));      // false (duplicate)

        set.add("C++");
        set.add("JavaScript");

        System.out.println(set); // [Java, C++, Python, JavaScript] (order varies)

        // contains()
        System.out.println(set.contains("Java")); // true
        System.out.println(set.contains("Ruby")); // false

        // remove()
        set.remove("C++");
        System.out.println(set); // [Java, Python, JavaScript]

        // size() / isEmpty()
        System.out.println(set.size());      // 3
        System.out.println(set.isEmpty());   // false

        // Iteration
        for (String lang : set) {
            System.out.println(lang);
        }

        // addAll() - union of two sets
        HashSet<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        HashSet<Integer> b = new HashSet<>(Arrays.asList(3, 4, 5, 6));

        HashSet<Integer> union = new HashSet<>(a);
        union.addAll(b);

        System.out.println("Union: " + union); // [1, 2, 3, 4, 5, 6]

        // retainAll() - intersection
        HashSet<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);

        System.out.println("Intersection: " + intersection); // [3, 4]

        // removeAll() - difference
        HashSet<Integer> diff = new HashSet<>(a);
        diff.removeAll(b);

        System.out.println("Difference (a-b): " + diff); // [1, 2]
    }
}