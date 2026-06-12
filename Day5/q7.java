// Grade Classifier
// Accept marks from the user and display:
// •	A (90+)
// •	B (80–89)
// •	C (70–79)
// •	D (60–69)
// •	F (<60)


import java.util.Scanner;

public class q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        switch (marks / 10) {
            case 10:
            case 9:
                System.out.println("Grade: A");
                break;

            case 8:
                System.out.println("Grade: B");
                break;

            case 7:
                System.out.println("Grade: C");
                break;

            case 6:
                System.out.println("Grade: D");
                break;

            default:
                System.out.println("Grade: F");
        }

        sc.close();
    }
}