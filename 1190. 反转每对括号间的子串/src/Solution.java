import java.util.*;

/**
 * @author CuiJunJie
 * @create 2021/5/26-16:56
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseParentheses("(abcd)"));
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    public static String reverseParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>(s.length());
        for (char c : s.toCharArray()) {
            if (c == ')') {
                List<Character> list = new ArrayList<>();
                while (stack.peek() != '(') {
                    list.add(stack.pop());
                }
                stack.pop();
                for (int i = 0; i < list.size(); i++) {
                    stack.push(list.get(i));
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        return sb.toString();
    }
}
