import java.util.Stack;

/**
 * @author cuijunjie
 * @create 2020--04-10:37
 */
public class Solution {
    public static void main(String[] args) {

        System.out.println(isValid( "(]"));

    }

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        char left;
        char right;
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
                continue;
            }
            left = stack.peek();
            right = s.charAt(i);
            if (left == '(' && right == ')' ||
                    left == '[' && right == ']' ||
                    left == '{' && right == '}') {
                stack.pop();
            } else {
                stack.push(right);
            }
        }

        return stack.size() == 0;
    }
}
