package AccessModifiers;

class Parent {
    protected void show() {
        System.out.println("Protected method accessed");
    }
}

class Child extends Parent {
    void display() {
        show();
    }
}

public class q28 {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.display();
    }
}