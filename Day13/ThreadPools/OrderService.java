package ThreadPools;

import java.util.concurrent.*;

public class OrderService {
    public static void main(String[] args) throws Exception {

        // Run two tasks concurrently
        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            return "User: John Doe";
        });

        CompletableFuture<String> productFuture = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(800); } catch (InterruptedException e) {}
            return "Product: MacBook Pro";
        });

        // Combine both results when both complete
        CompletableFuture<String> orderFuture = userFuture.thenCombine(
                productFuture,
                (user, product) -> "Order created for [" + user + "] | Item: [" + product + "]"
        );

        // Chain transformation
        CompletableFuture<String> emailFuture = orderFuture.thenApply(
                order -> "Email sent: " + order
        );

        // Exception handling
        emailFuture
                .thenAccept(System.out::println)
                .exceptionally(ex -> {
                    System.err.println("Error: " + ex.getMessage());
                    return null;
                });

        emailFuture.get(); // Wait for completion
    }
}

// Output:
// Email sent: Order created for [User: John Doe] | Item: [Product: MacBook Pro]

