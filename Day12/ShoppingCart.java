public class ShoppingCart {
    public static void main(String[] args) {
        String[] items = {"Apple", "Banana", "Mango"};

        // NullPointerException — unchecked, occurs at runtime
        String item = null;
        System.out.println(item.length()); // Crash! NPE

        // ArrayIndexOutOfBoundsException — unchecked
        System.out.println(items[10]);   // Only 3 items exist

        // ArithmeticException — unchecked
        int discount = 100 / 0;          // Division by zero
    }
}

