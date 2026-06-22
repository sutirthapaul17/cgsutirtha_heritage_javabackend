import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {

        // Natural ordering (alphabetical for String keys)
        TreeMap<String, Integer> cityPop = new TreeMap<>();

        cityPop.put("Mumbai", 20000000);
        cityPop.put("Delhi", 32000000);
        cityPop.put("Bengaluru", 12000000);
        cityPop.put("Chennai", 7000000);
        cityPop.put("Kolkata", 14000000);

        System.out.println("Cities (alphabetical):");
        for (Map.Entry<String, Integer> e : cityPop.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // Bengaluru, Chennai, Delhi, Kolkata, Mumbai

        // Navigation methods
        System.out.println(cityPop.firstKey());          // Bengaluru
        System.out.println(cityPop.lastKey());           // Mumbai
        System.out.println(cityPop.floorKey("Delhi"));   // Delhi
        System.out.println(cityPop.ceilingKey("Kolkata"));// Kolkata
        System.out.println(cityPop.lowerKey("Delhi"));   // Chennai
        System.out.println(cityPop.higherKey("Delhi"));  // Kolkata

        // subMap() - range query
        SortedMap<String, Integer> sub =
                cityPop.subMap("Chennai", "Mumbai");

        System.out.println("Range: " + sub.keySet());
        // [Chennai, Delhi, Kolkata]

        // Reverse order
        TreeMap<String, Integer> reverse =
                new TreeMap<>(Comparator.reverseOrder());

        reverse.putAll(cityPop);

        System.out.println("Reverse: " + reverse.keySet());
        // [Mumbai, Kolkata, Delhi, Chennai, Bengaluru]

        // TreeMap with Integer keys (sorted numerically)
        TreeMap<Integer, String> grades = new TreeMap<>();

        grades.put(85, "B");
        grades.put(95, "A");
        grades.put(75, "C");
        grades.put(55, "F");

        System.out.println(grades);
        // {55=F, 75=C, 85=B, 95=A}
    }
}