package ThreadPools;

import java.util.concurrent.*;

public class ImageProcessingService {

    public static void main(String[] args) throws InterruptedException {
        // Create a fixed pool of 3 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        String[] images = {
                "img1.jpg", "img2.png", "img3.jpg", "img4.png",
                "img5.jpg", "img6.png", "img7.jpg", "img8.png",
                "img9.jpg", "img10.png"
        };

        for (String image : images) {
            executor.submit(() -> {  // Submit Runnable task
                String threadName = Thread.currentThread().getName();
                System.out.println("[" + threadName + "] Compressing: " + image);
                try {
                    Thread.sleep(1000); // Simulate compression
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("[" + threadName + "] Done: " + image);
            });
        }

        executor.shutdown();  // No new tasks accepted
        executor.awaitTermination(30, TimeUnit.SECONDS);  // Wait for all to finish
        System.out.println("All images processed!");
    }
}

// Output shows 3 threads reused across 10 tasks:
// [pool-1-thread-1] Compressing: img1.jpg
// [pool-1-thread-2] Compressing: img2.png
// [pool-1-thread-3] Compressing: img3.jpg
// [pool-1-thread-1] Done: img1.jpg
// [pool-1-thread-1] Compressing: img4.png   <-- thread-1 reused!

