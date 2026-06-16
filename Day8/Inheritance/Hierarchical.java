package Inheritance;

class Person { 

    String name; 
    String email; 

    Person(String name, String email) { 
        this.name = name; 
        this.email = email; 
    } 

    void greet() { 
        System.out.println("Hello, I am " + name + ". Email: " + email); 
    }
} 

class Teacher extends Person { 

    String subject; 
    Teacher(String name, String email, String subject) { 
        super(name, email); 
        this.subject = subject; 
    } 

    void teach() { 
        System.out.println(name + " is teaching " + subject); 
    } 
} 

 

class Student extends Person { 

    int rollNumber; 
    double gpa; 
    Student(String name, String email, int roll, double gpa) { 

        super(name, email); 
        this.rollNumber = roll; 
        this.gpa = gpa; 
    } 

    void study() { 
        System.out.println(name + " (Roll: " + rollNumber + ") is studying. GPA: " + gpa); 
    }
} 

 

public class Hierarchical { 

    public static void main(String[] args) { 

        Teacher t = new Teacher("Dr. Sharma", "sharma@school.com", "Physics"); 
        Student s = new Student("Raj", "raj@school.com", 101, 3.8); 

        t.greet();   // Inherited from Person 
        t.teach();   // Teacher's own method 
        s.greet();   // Inherited from Person 
        s.study();   // Student's own method 

    } 

} 