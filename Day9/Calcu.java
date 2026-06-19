
class Calculator {

    // Overload 1 — two integers
    public int add(int a, int b) {
        System.out.println("[int+int]");
        return a + b;
    }

    // Overload 2 — three integers
    public int add(int a, int b, int c) {
        System.out.println("[int+int+int]");
        return a + b + c;
    }

    // Overload 3 — two doubles
    public double add(double a, double b) {
        System.out.println("[double+double]");
        return a + b;
    }

    // Overload 4 — String concatenation
    public String add(String a, String b) {
        System.out.println("[String+String]");
        return a + b;
    }

    // Overload 5 — mixed types
    public double add(int a, double b) {
        System.out.println("[int+double]");
        return a + b;
    }

}


public class Calcu {
    public static void main(String[] args) {
        // Usage — compiler decides at compile time which to call
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 3));          // Calls Overload 1 → 8
        System.out.println(calc.add(5, 3, 2));        // Calls Overload 2 → 10
        System.out.println(calc.add(5.5, 2.3));       // Calls Overload 3 → 7.8
        System.out.println(calc.add("Hello, ","World")); // Calls Overload 4
        System.out.println(calc.add(3, 4.5));          // Calls Overload 5 → 7.5
    }
}
