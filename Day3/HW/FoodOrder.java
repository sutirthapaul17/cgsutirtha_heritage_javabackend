package HW;
import java.util.Scanner;
public class FoodOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Burger");
        System.out.println("2. Pizza");
        System.out.println("3. Sandwich");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("You ordered Burger.");
                break;
            case 2:
                System.out.println("You ordered Pizza.");
                break;
            case 3:
                System.out.println("You ordered Sandwich.");
                break;
            default:
                System.out.println("Invalid Choice.");
        }

        sc.close();
    }
}