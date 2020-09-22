import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author CuiJunJie
 * @create 2020-09-19-16:33
 */
public class Solution {
    public static void main(String[] args) {
        String[] tokens =  {"10"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int k = 0;
        stack.push(Integer.parseInt(tokens[k++]));
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
        while (!stack.isEmpty() && k < tokens.length) {
            if (pattern.matcher(tokens[k]).matches()) {
                stack.push(Integer.parseInt(tokens[k++]));
            } else {
                Integer r = oP(stack.pop(), stack.pop(), tokens[k++]);
                stack.push(r);
            }
        }

        return stack.pop();
    }

    private static int oP(Integer a, Integer b, String c) {
        if ("+".equals(c)) {
            return b + a;
        } else if ("-".equals(c)) {
            return b - a;
        } else if ("*".equals(c)) {
            return b * a;
        } else {
            return b / a;
        }
    }
}
