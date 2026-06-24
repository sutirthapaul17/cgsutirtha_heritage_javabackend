package ThreadPools;

import java.util.concurrent.*;

public class PortfolioService {

    // Callable returns a result (unlike Runnable)
    static Callable<Double> fetchStockPrice(String ticker, double price) {
        return () -> {
            System.out.println(Thread.currentThread().getName()
                    + " | Fetching price for: " + ticker);
            Thread.sleep(1500); // Simulate API call
            System.out.println(Thread.currentThread().getName()
                    + " | Price of " + ticker + " = $" + price);
            return price;
        };
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 3 Callable tasks — runs concurrently
        Future<Double> applePrice  = executor.submit(fetchStockPrice("AAPL", 185.50));
        Future<Double> googlePrice = executor.submit(fetchStockPrice("GOOGL", 140.20));
        Future<Double> msftPrice   = executor.submit(fetchStockPrice("MSFT",  415.80));

        // get() BLOCKS until the result is ready
        double portfolio = applePrice.get() + googlePrice.get() + msftPrice.get();

        System.out.printf("Total portfolio value: $%.2f%n", portfolio);

        executor.shutdown();
    }
}

// All 3 API calls run in parallel (1.5s total vs 4.5s sequential!)

