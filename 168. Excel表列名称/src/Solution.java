/**
 * @author CuiJunJie
 * @create 2020-09-25-16:30
 */
public class Solution {
    public static void main(String[] args) {
        int n = 701;
        System.out.println(convertToTitle(n));
    }

    public static String convertToTitle(int n) {
        if (n < 1) {
            return "";
        }

        StringBuilder ret = new StringBuilder();
        while (n != 0) {
            n--;
            int num = n % 26;
            ret.append((char) (num + 'A'));
            n = n / 26;

        }

        return ret.reverse().toString();
    }
}
