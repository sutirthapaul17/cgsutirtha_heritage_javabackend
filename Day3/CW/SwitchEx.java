package CW;

public class SwitchEx {
    public static void main(String[] args) {
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;   // Critical: prevents fall-through
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Thursday");
                break;
            case 4:
                System.out.println("Mid-week"); // Fall-through: both 3 & 4
                break;
            default:
                System.out.println("Other day");
        }

    }
}
