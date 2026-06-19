package Encapsulation;

class Person {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid Age");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class q23 {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Rahul");
        p.setAge(25);
        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
    }
}