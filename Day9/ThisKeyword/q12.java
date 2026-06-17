package ThisKeyword;

class Student2 {
    int id;
    String name;

    // Default constructor
    Student2() {
        this(101, "Rahul"); // Calling parameterized constructor
        System.out.println("Default Constructor Called");
    }

    // Parameterized constructor
    Student2(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Parameterized Constructor Called");
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

public class q12 {
    public static void main(String[] args) {
        Student2 s = new Student2();
        s.display();
    }
}