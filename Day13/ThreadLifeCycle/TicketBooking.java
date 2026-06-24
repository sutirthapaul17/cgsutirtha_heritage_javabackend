package ThreadLifeCycle;

public class TicketBooking {

    public static void main(String[] args) throws InterruptedException {

        Thread bookingThread = new Thread(() -> {
            System.out.println("[Booking] Reserving seat...");
            try {
                Thread.sleep(3000); // TIMED_WAITING for 3 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("[Booking] Seat reserved!");
        }, "BookingThread");

        System.out.println("State before start: " + bookingThread.getState()); // NEW

        bookingThread.start();
        System.out.println("State after start:  " + bookingThread.getState()); // RUNNABLE

        Thread.sleep(500); // Let bookingThread enter sleep
        System.out.println("State while sleeping: " + bookingThread.getState()); // TIMED_WAITING

        bookingThread.join(); // Main thread waits for bookingThread to finish
        System.out.println("State after finish: " + bookingThread.getState()); // TERMINATED
    }
}
