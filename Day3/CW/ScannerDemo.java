package CW;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your GPA: ");
        double gpa = sc.nextDouble();

        System.out.println("Name: " + name + ", Age: " + age + ", GPA: " + gpa);
        sc.close();
    }
}

