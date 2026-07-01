import java.util.ArrayDeque;

class PrinterQueue {

    private ArrayDeque<String> queue;
    public PrinterQueue() {
        queue = new ArrayDeque<>();
    }
    public void addJob(String jobName) {
        if (jobName == null || jobName.trim().isEmpty()) {
            throw new IllegalArgumentException("Job name cannot be null or empty.");
        }
        queue.offer(jobName);
        System.out.println("Added Job: " + jobName);
    }
    public void processJob() {
        if (queue.isEmpty()) {
            System.out.println("No print jobs available.");
            return;
        }
        String job = queue.poll();
        System.out.println("Printing: " + job);
    }
    public String peekJob() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Printer queue is empty.");
        }
        return queue.peek();
    }
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Printer Queue is empty.");
            return;
        }
        System.out.println("Pending Jobs: " + queue);
    }
}

public class PrinterQueueAss6 {

    public static void main(String[] args) {
        PrinterQueue printer = new PrinterQueue();
        printer.addJob("Resume.pdf");
        printer.addJob("Assignment.docx");
        printer.addJob("ProjectReport.pdf");

        printer.displayQueue();
        System.out.println("Next Job: " + printer.peekJob());
        printer.processJob();
        printer.processJob();
        printer.displayQueue();
        printer.processJob();
        printer.processJob();
        try {
            printer.addJob("");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}