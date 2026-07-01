import java.util.ArrayDeque;

class InfixToPostfix {

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    public static String convert(String infix) {
        if (infix == null) {
            throw new IllegalArgumentException("Expression cannot be null.");
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder postfix = new StringBuilder();
        for (char ch : infix.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                continue;
            }
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Invalid Expression: Unmatched parentheses.");
                }
                stack.pop();
            }
            else if (ch == '+' || ch == '-' || ch == '*' ||
                    ch == '/' || ch == '^') {
                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
            else {
                throw new IllegalArgumentException(
                        "Invalid character found: " + ch);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                throw new IllegalArgumentException("Invalid Expression: Unmatched parentheses.");
            }
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
}

public class InfixToPostfixConversion {

    public static void main(String[] args) {
        String[] expressions = {
                "A+B",
                "A+B*C",
                "(A+B)*C",
                "A*(B+C)/D",
                "A+B*(C-D)",
                "((A+B)",
                "A+B$C"
        };
        for (String expr : expressions) {
            try {
                System.out.println("Infix   : " + expr);
                System.out.println("Postfix : " +
                        InfixToPostfix.convert(expr));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("---------------------------");
        }
    }
}