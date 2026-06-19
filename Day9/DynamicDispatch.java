// Demonstrating dynamic dispatch clearly

// Static methods are NOT dynamically dispatched (bound at compile time)
class Parent {
    public static void staticMethod() {
        System.out.println("Parent static");
    }
    public void instanceMethod() {
        System.out.println("Parent instance");
    }
}

class Child extends Parent {
    public static void staticMethod() { System.out.println("Child static"); }

    @Override
    public void instanceMethod()      { System.out.println("Child instance"); }
}

public class DynamicDispatch {
    public static void main(String[] args) {
        Parent ref = new Child();
        ref.staticMethod();   // → "Parent static"  — compile-time binding!
        ref.instanceMethod(); // → "Child instance" — runtime binding!
    }
}