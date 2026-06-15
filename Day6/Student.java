public class Student { 

    String name; 
    int age; 
    String course; 

    // 1. Default Constructor (no arguments) 
    Student() { 
        name = "Unknown"; 
        age = 0; 
        course = "Not Enrolled"; 
    } 

    // 2. Parameterized Constructor 
    Student(String name, int age) { 
        this.name = name; 
        this.age = age; 
        this.course = "General"; 

    } 

    // 3. Overloaded Constructor (different parameter list) 
    Student(String name, int age, String course) { 

        this.name = name; 
        this.age = age; 
        this.course = course; 

    } 


    void show() { 
        System.out.println(name + " | Age: " + age + " | Course: " + course); 
    } 

    public static void main(String[] args) { 

        Student s1 = new Student();                       // default 
        Student s2 = new Student("Riya", 20);              // parameterized 
        Student s3 = new Student("Aman", 22, "B.Tech CSE"); // overloaded 

        s1.show(); 
        s2.show(); 
        s3.show(); 

    } 

} 