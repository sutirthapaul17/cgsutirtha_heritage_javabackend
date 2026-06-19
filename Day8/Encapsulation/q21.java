package Encapsulation;

class Student {
    private int id;
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class q21 {
    public static void main(String[] args) {
        Student s = new Student();
        s.setId(101);
        s.setName("Rahul");
        System.out.println("ID: " + s.getId());
        System.out.println("Name: " + s.getName());
    }
}