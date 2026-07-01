import java.util.ArrayDeque;

class StackUsingDeque {
    private ArrayDeque<Integer> stack;

    public StackUsingDeque() {
        stack = new ArrayDeque<>();
    }
    public void push(int value) {
        stack.push(value);
        System.out.println(value + " pushed into stack.");
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow! Cannot pop from an empty stack.");
        }
        return stack.pop();
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. No top element.");
        }
        return stack.peek();
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public void display() {
        System.out.println("Stack: " + stack);
    }
}

public class Stack {

    public static void main(String[] args) {
        StackUsingDeque stack = new StackUsingDeque();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println("Top Element: " + stack.peek());
        System.out.println("Popped Element: " + stack.pop());

        stack.display();
        System.out.println("Is Stack Empty? " + stack.isEmpty());
        stack.pop();
        stack.pop();

        System.out.println("Is Stack Empty? " + stack.isEmpty());
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
