package ThisKeyword;

class Student4 {
    int id;
    String name;

    Student4 setId(int id) {
        this.id = id;
        return this;
    }

    Student4 setName(String name) {
        this.name = name;
        return this;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

public class q15 {
    public static void main(String[] args) {

        Student4 student = new Student4();

        student.setId(1)
               .setName("Rahul");

        student.display();
    }
}