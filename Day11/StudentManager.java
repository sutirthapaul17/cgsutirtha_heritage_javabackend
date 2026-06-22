import java.util.*;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        // Enrolling students
        students.add("Ananya");
        students.add("Rahul");
        students.add("Priya");
        students.add("Dev");
        System.out.println("Enrolled: " + students);

        // A student drops out
        students.remove("Dev");
        System.out.println("After drop: " + students);

        // Insert a transfer student at position 1
        students.add(1, "Meera");
        System.out.println("After transfer: " + students);

        // Roll call
        System.out.println("\nRoll Call:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }

        // Search
        String search = "Priya";
        if (students.contains(search)) {
            int pos = students.indexOf(search);
            System.out.println(search + " is at roll no " + (pos + 1));
        }
    }
}

// OUTPUT:
// Enrolled: [Ananya, Rahul, Priya, Dev]
// After drop: [Ananya, Rahul, Priya]
// After transfer: [Ananya, Meera, Rahul, Priya]
// Roll Call:
// 1. Ananya  2. Meera  3. Rahul  4. Priya
// Priya is at roll no 4
