package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParentheses {


    public static boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();


        for (char ch : s.toCharArray()) {
            // Push all opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // For closing brackets, check matching opening
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false; // no opening bracket
                char top = stack.pop();
                if (ch == ')' && top != '(') return false;
                if (ch == ']' && top != '[') return false;
                if (ch == '}' && top != '{') return false;
            }
        }
        return stack.isEmpty(); // must be empty if balanced
    }


    public static void main(String[] args) {
        System.out.println(isBalanced("({[]})"));  // true
        System.out.println(isBalanced("({)}"));    // false
        System.out.println(isBalanced("[[[]]]"));  // true
        System.out.println(isBalanced("((("));     // false
    }

}