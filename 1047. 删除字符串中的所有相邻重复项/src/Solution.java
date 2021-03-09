import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2021/3/9-9:27
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String S) {
        if (S == null || S.length() < 1) {
            return S;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().equals(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuffer sb = new StringBuffer(stack.size());
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();

        return sb.toString();
    }
}
