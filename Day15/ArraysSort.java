import java.util.Arrays;
import java.util.Comparator;

public class ArraysSort {
    public static void main(String[] args) {
        // Sort primitive array (ascending) — O(n log n)
        int[] nums = {5, 2, 8, 1, 9};
        Arrays.sort(nums);  // [1, 2, 5, 8, 9]
        // Sort String array (alphabetical)
        String[] names = {"Charlie", "Alice", "Bob"};
        Arrays.sort(names); // [Alice, Bob, Charlie]
        // Sort Integer array DESCENDING (needs Integer[], not int[])
        Integer[] scores = {85, 92, 78, 95, 88};
        Arrays.sort(scores, Comparator.reverseOrder());
        // [95, 92, 88, 85, 78]
        // Sort by custom property (e.g., sort students by marks)
        String[][] students = {{"Alice","95"},{"Bob","78"},{"Carol","88"}};
        Arrays.sort(students, (a, b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));
        // Sorted: [[Bob,78],[Carol,88],[Alice,95]]
        // Sort part of array (indices 1 to 3 inclusive)
        int[] partial = {9, 5, 3, 7, 1};
        Arrays.sort(partial, 1, 4); // sort index 1,2,3 only

    }
}
