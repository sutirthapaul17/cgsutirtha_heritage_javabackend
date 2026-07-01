import java.util.ArrayDeque;

class BalancedParentheses {

    public static boolean isBalanced(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

public class ParenthesisChecker {

    public static void main(String[] args) {

        String[] testCases = {
                "()",
                "()[]{}",
                "{[()]}",
                "{[(])}",
                "(((",
                "([])",
                "",
                "a+(b*c)-{d/e}"
        };

        for (String str : testCases) {
            System.out.println(str + " -> " + BalancedParentheses.isBalanced(str));
        }
        try {
            BalancedParentheses.isBalanced(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}