import java.util.ArrayList;
import java.util.List;

public class ArrayListOps {

    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

// add(element) – appends at end
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println(fruits);  // [Apple, Banana, Cherry]

// add(index, element) – inserts at position
        fruits.add(1, "Avocado");
        System.out.println(fruits);  // [Apple, Avocado, Banana, Cherry]

// addAll(collection) – adds all elements of another collection
        List<String> moreFruits = new ArrayList<>();
        moreFruits.add("Mango");
        moreFruits.add("Papaya");
        fruits.addAll(moreFruits);
        System.out.println(fruits);  // [Apple, Avocado, Banana, Cherry, Mango, Papaya]


        // get(index) – 0-based index
        System.out.println(fruits.get(0));  // Apple
        System.out.println(fruits.get(2));  // Cherry

// Safe access with bounds check
        int index = 1;
        if (index >= 0 && index < fruits.size()) {
            System.out.println(fruits.get(index));  // Banana
        }

        fruits.remove(0);  // removes Apple
        System.out.println(fruits);  // [Banana, Cherry, Banana]

// remove(Object o) – removes FIRST occurrence by value
        fruits.remove("Banana");
        System.out.println(fruits);  // [Cherry, Banana]

// removeAll(collection) – removes all matching elements
        fruits.add("Apple"); fruits.add("Apple");
        fruits.removeAll(java.util.Arrays.asList("Apple"));
        System.out.println(fruits);  // [Cherry, Banana]

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10); nums.add(20); nums.add(30);
        nums.remove(0);              // removes index 0 → removes 10
        nums.remove(Integer.valueOf(20));  // removes the VALUE 20
        System.out.println(nums);  // [30]


        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.size());    // 0
        System.out.println(list.isEmpty()); // true

        list.add("A"); list.add("B"); list.add("C");
        System.out.println(list.size());    // 3
        System.out.println(list.isEmpty()); // false

// indexOf and lastIndexOf
        list.add("A");  // now: [A, B, C, A]
        System.out.println(list.indexOf("A"));     // 0 (first)
        System.out.println(list.lastIndexOf("A")); // 3 (last)

// clear() removes all elements but keeps capacity
        list.clear();
        System.out.println(list.size());    // 0
        System.out.println(list.isEmpty()); // true


    }

}
