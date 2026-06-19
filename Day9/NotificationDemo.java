

// The Notification contract
interface Notifiable {
    void sendNotification(String recipient, String message);
    boolean isDelivered();
    String getNotificationType();
}

// Email implementation
class EmailNotification implements Notifiable {
    private boolean delivered = false;
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending EMAIL to: " + recipient);
        System.out.println("Subject: Notification | Body: " + message);
        delivered = true;
    }

    @Override
    public boolean isDelivered() { return delivered; }

    @Override
    public String getNotificationType() { return "EMAIL"; }
}

// SMS implementation
class SMSNotification implements Notifiable {
    private boolean delivered = false;
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending SMS to: " + recipient);
        System.out.println("Message: " + message.substring(0, Math.min(160, message.length())));
        delivered = true;
    }

    @Override
    public boolean isDelivered() { return delivered; }

    @Override
    public String getNotificationType() { return "SMS"; }
}



// Usage
public class NotificationDemo {
    public static void notify(Notifiable n, String to, String msg) {
        n.sendNotification(to, msg);
        System.out.println("Delivered: " + n.isDelivered() + " via " + n.getNotificationType());
    }
    public static void main(String[] args) {
        notify(new EmailNotification(), "user@email.com", "Your order is confirmed!");
        notify(new SMSNotification(), "+91-9876543210", "OTP: 4821");
    }
}

