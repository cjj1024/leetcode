import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2020-11-04-11:23
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3+5 / 2 "));
        System.out.println(calculate("1337"));
        System.out.println(calculate("-1-1"));
    }

    public static int calculate(String s) {
        int ret = 0;
        int num = 0;
        StringBuilder sb = new StringBuilder();
        char op = '+';
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                sb.append(c);
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                i--;
                num = Integer.parseInt(sb.toString());
                sb.setLength(0);

                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                op = c;
            }
        }

        for (Integer integer : stack) {
            ret += integer;
        }

        return ret;
    }
}
