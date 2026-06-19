package Variables;

class Demo {
    int instanceVar = 100; // Instance variable

    void show() {
        int localVar = 50; // Local variable

        System.out.println("Instance Variable: " + instanceVar);
        System.out.println("Local Variable: " + localVar);
    }
}

public class q16 {
    public static void main(String[] args) {
        Demo obj = new Demo();
        obj.show();
    }
}