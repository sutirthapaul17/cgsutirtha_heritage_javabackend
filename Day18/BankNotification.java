class Notification{
    void send(){System.out.println("Notification");}
}
class EmailNotification extends Notification{
    void send(){System.out.println("Email Notification");}
}
class SMSNotification extends Notification{
    void send(){System.out.println("SMS Notification");}
}
class PushNotification extends Notification{
    void send(){System.out.println("Push Notification");}
}
public class BankNotification{
    public static void main(String[] args){
        new EmailNotification().send();
        new SMSNotification().send();
        new PushNotification().send();
    }
}
