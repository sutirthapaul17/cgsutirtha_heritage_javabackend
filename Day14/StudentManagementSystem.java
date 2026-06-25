
class Student {

    private int id;
    private String name;
    private double marks;

    public Student() {
    }

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String calculateGrade() {
        if (marks >= 90)
            return "A+";
        else if (marks >= 80)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 50)
            return "D";
        else
            return "F";
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", grade='" + calculateGrade() + '\'' +
                '}';
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Student[] students = {
                new Student(101, "Rahul", 85),
                new Student(102, "Priya", 92),
                new Student(103, "Amit", 78),
                new Student(104, "Sneha", 88)
        };
        System.out.println("Student Details:");
        for (Student s : students) {
            System.out.println(s);
        }
        Student topper = students[0];

        for (int i = 1; i < students.length; i++) {
            if (students[i].getMarks() > topper.getMarks()) {
                topper = students[i];
            }
        }

        System.out.println("\nTopper Details:");
        System.out.println(topper);
    }
}