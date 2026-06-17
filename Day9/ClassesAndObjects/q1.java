// Create a Student class with attributes: 
// id 
// name 
// course 
// Create an object and display the details. 

package ClassesAndObjects;

class Student {
    int id;
    String name;
    String course;


    Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Course: " + course);
    }
}

public class q1 {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Sutirtha", "B.Tech CSE");
        s1.display();
    }
}