import java.util.Collections;
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
//        System.out.println(calculate("-1-1"));
        System.out.println(calculate("1-1+1"));
        System.out.println(calculate("0-2147483647"));
    }

    public static int calculate(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char c;
        int i = 0;
        while (i < s.length()) {
            c = s.charAt(i);
            i++;
            if (c == ' ') {
                continue;
            } else if (c == '*') {
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                stack.push(String.valueOf(Integer.parseInt(stack.pop()) * Integer.parseInt(sb.toString())));
                sb.setLength(0);
            } else if (c == '/') {
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                stack.push(String.valueOf(Integer.parseInt(stack.pop()) / Integer.parseInt(sb.toString())));
                sb.setLength(0);
            } else if (Character.isDigit(c)) {
                sb.append(c);
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                stack.push(sb.toString());
                sb.setLength(0);
            } else {
                stack.push(String.valueOf(c));
            }
        }
        if (sb.length() > 0) {
            stack.push(sb.toString());
        }

        Collections.reverse(stack);
        while (stack.size() > 1) {
            int num = Integer.parseInt(stack.pop());
            String op = stack.pop();
            if (op.equals("+")) {
                stack.push(String.valueOf(Integer.parseInt(stack.pop()) + num));
            } else {
                stack.push(String.valueOf(num - Integer.parseInt(stack.pop())));
            }
        }

        return Integer.parseInt(stack.peek());
    }

//    public static int calculate(String s) {
//        int ret = 0;
//        int num = 0;
//        StringBuilder sb = new StringBuilder();
//        char op = '+';
//        Stack<Integer> stack = new Stack<>();
//        stack.push(0);
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == ' ') {
//                continue;
//            } else if (Character.isDigit(c)) {
//                sb.append(c);
//                i++;
//                while (i < s.length() && Character.isDigit(s.charAt(i))) {
//                    sb.append(s.charAt(i));
//                    i++;
//                }
//                i--;
//                num = Integer.parseInt(sb.toString());
//                sb.setLength(0);
//
//                if (op == '+') {
//                    stack.push(num);
//                } else if (op == '-') {
//                    stack.push(-num);
//                } else if (op == '*') {
//                    stack.push(stack.pop() * num);
//                } else if (op == '/') {
//                    stack.push(stack.pop() / num);
//                }
//            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
//                op = c;
//            }
//        }
//
//        for (Integer integer : stack) {
//            ret += integer;
//        }
//
//        return ret;
//    }
}
