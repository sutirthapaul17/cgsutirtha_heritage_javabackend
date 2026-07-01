package Stack;

import java.util.Stack;

public class StackUsingLegacyStack {
    public static void main(String[] args) {
        Stack<String> history = new Stack<>();
        history.push("Page1");
        history.push("Page2");
        history.push("Page3");
        System.out.println(history.peek()); // Page3
        System.out.println(history.pop());  // Page3 (go back)
        System.out.println(history.pop());  // Page2 (go back)
        System.out.println(history.peek()); // Page1 (current page)
        // Note: Stack class is thread-safe but slower than ArrayDeque
        // Prefer ArrayDeque for single-threaded use
    }
}
