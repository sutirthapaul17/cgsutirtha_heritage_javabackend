package Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingArrayDeque {
    public static void main(String[] args) {
        // ArrayDeque is faster than Stack class (no synchronization overhead)
        Deque<Integer> stack = new ArrayDeque<>();
        // Push elements
        stack.push(10); // stack: [10]
        stack.push(20); // stack: [20, 10]
        stack.push(30); // stack: [30, 20, 10] ← top is 30
        // Peek at top
        System.out.println(stack.peek()); // 30 (not removed)
        // Pop elements
        System.out.println(stack.pop()); // 30, stack: [20, 10]
        System.out.println(stack.pop()); // 20, stack: [10]
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack.size());    // 1

    }
}
