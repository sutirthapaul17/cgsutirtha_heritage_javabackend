package ThisKeyword;

class Student3 {
    int id;
    String name;

    Student3(int id, String name) {
        this.id = id;
        this.name = name;
    }

    Student3 getStudent() {
        return this; // returns current object
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

public class q13 {
    public static void main(String[] args) {
        Student3 s1 = new Student3(101, "Rahul");

        Student3 s2 = s1.getStudent();

        s2.display();
    }
}