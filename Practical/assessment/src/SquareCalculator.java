import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SquareCalculator {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int number : numbers) {
            executor.submit(() -> {
                int square = number * number;
                System.out.println("Square of " + number + " = " + square);
            });
        }

        // No more tasks will be accepted; already submitted tasks will run to completion
        executor.shutdown();

        try {
            // Wait for all tasks to finish, or time out after 60 seconds
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // Force shutdown if tasks don't finish in time
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("All tasks completed");
    }
}
