import java.util.Stack;

/**
 * @author cuijunjie
 * @create 2020--06-14:08
 */
public class Solution {
    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParentheses(s));
    }


    public static int longestValidParentheses(String s) {
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ret = Math.max(ret, i - stack.peek());
                }
            }
        }

        return ret;
    }

//    public static int longestValidParentheses(String s) {
//        int[] dp = new int[s.length()];
//        char[] charArray = s.toCharArray();
//        int ret = 0;
//        for (int i = 1; i < charArray.length; i++) {
//            if (charArray[i] == ')') {
//                if (charArray[i - 1] == '(') {
//                    dp[i] = i > 1 ? dp[i - 2] + 2 : 2;
//                } else if (i - dp[i - 1] > 0 && charArray[i - dp[i - 1] - 1] == '(') {
//                    dp[i] = dp[i - 1] + (i - dp[i - 1] >=2 ? dp[i - dp[i - 1] - 2] + 2 : 2);
//                }
//            }
//            ret = Math.max(ret, dp[i]);
//        }
//
//        return ret;
//    }
}
