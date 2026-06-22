import java.util.LinkedList;

public class BrowserHistory {
    public static void main(String[] args) {
        LinkedList<String> history = new LinkedList<>();

        // User visits pages
        history.addFirst("google.com");
        history.addFirst("youtube.com");
        history.addFirst("github.com");
        history.addFirst("stackoverflow.com");

        System.out.println("History (most recent first):");
        System.out.println(history);

        // Back button (go to previous page)
        System.out.println("\nClicking Back:");
        System.out.println("Leaving: " + history.removeFirst());
        System.out.println("Now at:  " + history.getFirst());

        // Back again
        System.out.println("\nClicking Back:");
        System.out.println("Leaving: " + history.removeFirst());
        System.out.println("Now at:  " + history.getFirst());
    }
}
