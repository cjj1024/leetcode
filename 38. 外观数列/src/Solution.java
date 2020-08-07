/**
 * @author cuijunjie
 * @create 2020--07-14:01
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder(n);
        recursion(n, sb);

        return sb.toString();
    }

    public static void recursion(int n, StringBuilder sb) {
        if (n == 1) {
            sb.append(1);
            return;
        }

        recursion(n - 1, sb);
        char[] preChar = sb.toString().toCharArray();
        sb.setLength(0);
        for (int i = 0; i < preChar.length; ++i) {
            int num = 1;
            while (i + 1 < preChar.length && preChar[i] == preChar[i + 1]) {
                ++i;
                ++num;
            }
            sb.append(String.valueOf(num));
            sb.append(String.valueOf(preChar[i]));
        }
    }
}
