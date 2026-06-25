import java.util.Scanner;

class Student2 {
    String name;
    double marks;

    public Student2(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getGrade() {
        if (marks >= 90)
            return "A";
        else if (marks >= 80)
            return "B";
        else if (marks >= 70)
            return "C";
        else if (marks >= 60)
            return "D";
        else
            return "F";
    }
}

public class UniversityResultProcessing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student2[] students = new Student2[n];

        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Marks: ");
            double marks = sc.nextDouble();
            sc.nextLine();

            students[i] = new Student2(name, marks);
            total += marks;
        }

        Student2 topper = students[0];
        Student2 lowest = students[0];

        for (int i = 1; i < n; i++) {

            if (students[i].marks > topper.marks) {
                topper = students[i];
            }

            if (students[i].marks < lowest.marks) {
                lowest = students[i];
            }
        }
        double average = total / n;

        int gradeA = 0, gradeB = 0, gradeC = 0, gradeD = 0, gradeF = 0;

        for (Student2 s : students) {

            switch (s.getGrade()) {
                case "A":
                    gradeA++;
                    break;
                case "B":
                    gradeB++;
                    break;
                case "C":
                    gradeC++;
                    break;
                case "D":
                    gradeD++;
                    break;
                default:
                    gradeF++;
            }
        }
        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (students[j].marks < students[j + 1].marks) {

                    Student2 temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("\n===== RESULT ANALYSIS =====");

        System.out.println("Topper: " + topper.name +
                " (" + topper.marks + ")");

        System.out.println("Highest Marks: " +
                topper.marks);

        System.out.println("Lowest Marks: " +
                lowest.marks);

        System.out.println("Average Marks: " +
                average);

        System.out.println("\nGrade Distribution");
        System.out.println("A Grade : " + gradeA);
        System.out.println("B Grade : " + gradeB);
        System.out.println("C Grade : " + gradeC);
        System.out.println("D Grade : " + gradeD);
        System.out.println("F Grade : " + gradeF);

        System.out.println("\nStudents Sorted by Marks");

        for (Student2 s : students) {
            System.out.println(
                    s.name + " - " + s.marks + " - Grade " + s.getGrade()
            );
        }

        sc.close();
    }
}