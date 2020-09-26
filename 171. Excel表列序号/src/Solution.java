/**
 * @author CuiJunJie
 * @create 2020-09-26-10:37
 */
public class Solution {
    public static void main(String[] args) {
        String s = "ZY";
        System.out.println(titleToNumber(s));
    }

    public static int titleToNumber(String s) {
        int num = 0;
        for (char c : s.toCharArray()) {
            num = num * 26 + (c - 'A' + 1);
        }

        return num;
    }
}
