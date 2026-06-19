// Create a class demonstrating constructor overloading: 
// No parameter 
// One parameter 
// Two parameters 

package Constructors;

class Demo {

    Demo() {
        System.out.println("Constructor with no parameters called.");
    }

    Demo(String name) {
        System.out.println("Constructor with one parameter called.");
        System.out.println("Name: " + name);
    }

    Demo(String name, int age) {
        System.out.println("Constructor with two parameters called.");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class q9 {
    public static void main(String[] args) {
        Demo d1 = new Demo();
        System.out.println();
        Demo d2 = new Demo("Sutirtha");
        System.out.println();
        Demo d3 = new Demo("Sutirtha", 21);
    }
}