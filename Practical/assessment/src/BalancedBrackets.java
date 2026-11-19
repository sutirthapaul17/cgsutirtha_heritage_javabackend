import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(char ch : s.toCharArray()){
            if((ch=='(') || (ch == '[') || (ch=='{')){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char top = st.peek();
                if(top == map.get(ch)) st.pop();
                else return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {

        String test1 = "{[()()]}";
        String test2 = "{[(])}";

        System.out.println("Input: " + test1 + " -> Output: " + isValid(test1));
        System.out.println("Input: " + test2 + " -> Output: " + isValid(test2));
    }
}
