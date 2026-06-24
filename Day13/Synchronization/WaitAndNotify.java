package Synchronization;


class PizzaRestaurant {
    private boolean pizzaReady = false;

    // Chef thread calls this to prepare pizza
    public synchronized void preparePizza() throws InterruptedException {
        System.out.println("[Chef] Preparing pizza...");
        Thread.sleep(3000);
        pizzaReady = true;
        System.out.println("[Chef] Pizza is ready! Notifying customer.");
        notify(); // Wakes up the waiting customer thread
    }

    // Customer thread calls this to wait for pizza
    public synchronized void collectPizza() throws InterruptedException {
        while (!pizzaReady) {   // Always use while, not if (spurious wakeup safety)
            System.out.println("[Customer] Waiting for pizza...");
            wait(); // Releases lock and waits
        }
        System.out.println("[Customer] Got the pizza! Enjoying...");
    }
}

public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        PizzaRestaurant restaurant = new PizzaRestaurant();
        Thread chef     = new Thread(() -> { try { restaurant.preparePizza(); } catch(Exception e){} }, "Chef");
        Thread customer = new Thread(() -> { try { restaurant.collectPizza(); } catch(Exception e){} }, "Customer");
        customer.start();
        Thread.sleep(500);  // Ensure customer waits first
        chef.start();
    }
}

