import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2020-09-04-11:24
 */
public class Solution {
    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }

        char[] chars = s.toLowerCase().toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            while (i < j && !isValid(chars[i])) {
                i++;
            }
            while (i < j && !isValid(chars[j])) {
                j--;
            }
            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean isValid(Character c) {
        if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z') {
            return true;
        } else {
            return false;
        }
    }
}
