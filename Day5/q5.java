// String Operations
// Take a string input from the user and display:
// •	Length
// •	First Character
// •	Last Character
// •	Uppercase Version

import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.println("\nResults:");
        System.out.println("Length = " + str.length());

        if (!str.isEmpty()) {
            System.out.println("First Character = " + str.charAt(0));
            System.out.println("Last Character = " + str.charAt(str.length() - 1));
        } else {
            System.out.println("First Character = String is empty");
            System.out.println("Last Character = String is empty");
        }

        System.out.println("Uppercase Version = " + str.toUpperCase());

        sc.close();
    }
}