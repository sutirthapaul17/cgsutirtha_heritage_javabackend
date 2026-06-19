//3. University Management System
//Create:
//Person
//Student
//Professor
//Demonstrate:
//multilevel inheritance
//constructor chaining using super
//runtime polymorphism

class Person {
    String name;

    Person(String name) {
        this.name = name;
        System.out.println("Person Constructor Called");
    }

    void displayRole() {
        System.out.println("I am a Person");
    }
}

class Student extends Person {
    int rollNo;

    Student(String name, int rollNo) {
        super(name);
        this.rollNo = rollNo;
        System.out.println("Student Constructor Called");
    }

    @Override
    void displayRole() {
        System.out.println("I am a Student");
        System.out.println("Name: " + name);
        System.out.println("ID: " + rollNo);
    }
}

class Professor extends Student {
    String subject;

    Professor(String name, int rollNo, String subject) {
        super(name, rollNo);
        this.subject = subject;
        System.out.println("Professor Constructor Called");
    }

    @Override
    void displayRole() {
        System.out.println("I am a Professor");
        System.out.println("Name: " + name);
        System.out.println("ID: " + rollNo);
        System.out.println("Subject: " + subject);
    }
}

public class Q3 {
    public static void main(String[] args) {
        Person p1= new Student("Rahul", 101);
        p1.displayRole();

        System.out.println();

        Person p2 = new Professor("Dr. Sharma", 5001, "Java Programming");
        p2.displayRole();
    }
}