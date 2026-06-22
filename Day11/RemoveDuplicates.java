import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // Incoming data with duplicates
        List<String> emails = new ArrayList<>(Arrays.asList(
                "alice@mail.com", "bob@mail.com", "alice@mail.com",
                "carol@mail.com", "bob@mail.com", "dave@mail.com"
        ));

        System.out.println("Original: " + emails);
        System.out.println("Count: "    + emails.size());

        // Convert to HashSet to auto-remove duplicates
        HashSet<String> uniqueEmails = new HashSet<>(emails);

        System.out.println("\nUnique emails:");
        for (String email : uniqueEmails) {
            System.out.println("  " + email);
        }
        System.out.println("Unique count: " + uniqueEmails.size());
    }
}

