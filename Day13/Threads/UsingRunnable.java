package Threads;


// EmailNotifier.java
class EmailNotifier implements Runnable {
    private String recipientEmail;
    private String message;

    public EmailNotifier(String email, String message) {
        this.recipientEmail = email;
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " | Sending email to: " + recipientEmail);
        try {
            Thread.sleep(1500); // Simulates SMTP delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName()
                + " | Email sent successfully to: " + recipientEmail);
    }
}

// SMSNotifier.java  (reuses Runnable — no Thread coupling)
class SMSNotifier implements Runnable {
    private String phone;

    public SMSNotifier(String phone) { this.phone = phone; }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " | Sending SMS to: " + phone);
    }
}

// Main.java
public class UsingRunnable {
    public static void main(String[] args) {
        Runnable emailTask = new EmailNotifier("user@gmail.com", "Your order is confirmed!");
        Runnable smsTask   = new SMSNotifier("+91-9876543210");

        Thread emailThread = new Thread(emailTask, "EmailThread");
        Thread smsThread   = new Thread(smsTask,   "SMSThread");

        emailThread.start();
        smsThread.start();
    }
}
