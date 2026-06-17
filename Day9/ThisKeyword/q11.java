package ThisKeyword;


class Student {
    int id;
    String name;

    // Constructor
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

public class q11 {
    public static void main(String[] args) {
        Student3 s = new Student3(101, "Rahul");

        s.display();
    }
}