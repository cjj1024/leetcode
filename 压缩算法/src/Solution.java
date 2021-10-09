import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串 
     * @return string字符串
     */

    public static void main(String[] args) {
        System.out.println(compress("HG[3|B[2|CA]]F"));
    }

    public static String compress (String str) {
        // write code here
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (c == ']') {
                compressOne(stack);
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        return sb.toString();
    }

    public static void compressOne(Deque<Character> stack) {
        StringBuilder str = new StringBuilder();
        while (stack.peek() != '|') {
            str.append(stack.pop());
        }
        str.reverse();
        stack.pop();

        StringBuilder numStr = new StringBuilder();
        while (stack.peek() != '[') {
            numStr.append(stack.pop());
        }
        stack.pop();
        numStr.reverse();

        int num = Integer.parseInt(numStr.toString());

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < str.length(); j++) {
                stack.push(str.charAt(j));
            }
        }
    }
}
