package Threads;

public class Lambda {
}
// Inline lambda — great for short tasks
Thread reportThread = new Thread(() -> {
    System.out.println("Generating monthly sales report...");
    // report generation logic
    System.out.println("Report emailed to manager.");
}, "ReportThread");

reportThread.start();
