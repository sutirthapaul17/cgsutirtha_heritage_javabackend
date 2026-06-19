package AccessModifiers.q30.subpackage;

import AccessModifiers.q30.A;

public class B extends A {

    void display() {
        System.out.println(publicVar);
        System.out.println(protectedVar);

        // System.out.println(defaultVar); // Error
        // System.out.println(privateVar); // Error
    }

    public static void main(String[] args) {
        B obj = new B();
        obj.display();
    }
}