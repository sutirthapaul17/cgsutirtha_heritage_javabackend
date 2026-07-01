import java.util.*;

public class ProductViewTracker {
    private Map<String, Integer> viewCount = new HashMap<>();
    private Map<String, Set<String>> uniqueViewers = new HashMap<>();

    // Record a product view
    public void recordView(String productId, String userId) {
        // Total views
        viewCount.put(productId, viewCount.getOrDefault(productId, 0) + 1);

        // Unique viewers (using Set to avoid duplicates)
        uniqueViewers.computeIfAbsent(productId, k -> new HashSet<>()).add(userId);
    }

    // Get top N viewed products
    public List<Map.Entry<String, Integer>> getTopProducts(int n) {
        return viewCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(n)
                .collect(java.util.stream.Collectors.toList());
    }

    public static void main(String[] args) {
        ProductViewTracker tracker = new ProductViewTracker();
        tracker.recordView("P001", "user1");
        tracker.recordView("P001", "user2");
        tracker.recordView("P002", "user1");
        tracker.recordView("P001", "user3");
        tracker.recordView("P003", "user1");
        tracker.recordView("P002", "user4");

        System.out.println("Top 2 Products:");
        tracker.getTopProducts(2).forEach(e ->
                System.out.println(e.getKey() + " -> " + e.getValue() + " views"));
        // P001 -> 3 views
        // P002 -> 2 views
    }
}
