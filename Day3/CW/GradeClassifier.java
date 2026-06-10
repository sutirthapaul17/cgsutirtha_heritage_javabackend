package CW;

import java.util.Scanner;

public class GradeClassifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks (0-100): ");
        int marks = sc.nextInt();

        String grade;
        if (marks >= 90)       { grade = "A+ (Outstanding)"; }
        else if (marks >= 80)  { grade = "A  (Excellent)"; }
        else if (marks >= 70)  { grade = "B  (Good)"; }
        else if (marks >= 60)  { grade = "C  (Average)"; }
        else if (marks >= 50)  { grade = "D  (Below Average)"; }
        else                   { grade = "F  (Fail)"; }

        System.out.println("Grade: " + grade);
        sc.close();
    }
}

