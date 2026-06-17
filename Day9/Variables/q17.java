package Variables;

class Student {
    int rollNo;                 // Instance variable
    static String college = "ABC College"; // Static variable

    Student(int rollNo) {
        this.rollNo = rollNo;
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("College: " + college);
    }
}

public class q17 {
    public static void main(String[] args) {
        Student s1 = new Student(101);
        Student s2 = new Student(102);

        s1.display();
        System.out.println();

        s2.display();
    }
}