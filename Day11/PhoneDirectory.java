import java.util.*;

public class PhoneDirectory {
    public static void main(String[] args) {
        HashMap<String, String> directory = new HashMap<>();

        // Add contacts
        directory.put("Ravi",  "+91-9876543210");
        directory.put("Priya", "+91-9123456789");
        directory.put("Amar",  "+91-9988776655");

        // Lookup
        String name = "Priya";
        if (directory.containsKey(name)) {
            System.out.println(name + "'s number: " + directory.get(name));
        } else {
            System.out.println(name + " not found.");
        }

        // Update number
        directory.put("Ravi", "+91-9000000000");

        // Print all contacts
        System.out.println("\n=== All Contacts ===");
        for (Map.Entry<String, String> e : directory.entrySet()) {
            System.out.println(e.getKey() + "  →  " + e.getValue());
        }

        // Delete contact
        directory.remove("Amar");
        System.out.println("\nAfter delete: " + directory.keySet());
    }
}
