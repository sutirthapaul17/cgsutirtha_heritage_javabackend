

interface InterfaceA {
    default void greet() {
        System.out.println("Hello from Interface A");
    }
}

interface InterfaceB {
    default void greet() {
        System.out.println("Hello from Interface B");
    }
}

// MUST override to resolve ambiguity
class MyClass implements InterfaceA, InterfaceB {
    @Override
    public void greet() {
        InterfaceA.super.greet();  // explicitly call A's default
        // OR InterfaceB.super.greet()
        // OR write your own implementation
        System.out.println("MyClass greet — conflict resolved!");
    }
}

public class DefaultMethodConflictResolution {
}
