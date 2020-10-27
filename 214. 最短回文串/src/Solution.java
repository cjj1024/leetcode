/**
 * @author CuiJunJie
 * @create 2020-10-26-15:25
 */
public class Solution {
    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));
    }

    public static String shortestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        long left = 0;
        long right = 0;
        int maxLen = 0;
        long base = 131;
        long mod = 1000000007;
        long mul = 1;

        for (int i = 0; i < s.length(); i++) {
            left = (left * base + s.charAt(i)) % mod;
            right = (right + mul * s.charAt(i)) % mod;
            if (left == right) {
                maxLen = i;
            }
            mul = (mul * base) % mod;
        }

        return maxLen == s.length() - 1 ? s : new StringBuffer(s.substring(maxLen + 1)).reverse().append(s).toString();
    }

//    public static String shortestPalindrome(String s) {
//        if (s == null || s.length() < 2) {
//            return s;
//        }
//        int maxLen = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (isPalindrome(s.substring(0, i + 1))) {
//                maxLen = i;
//            }
//        }
//
//        return new StringBuffer(s.substring(maxLen + 1)).reverse().toString() + s;
//    }

    public static boolean isPalindrome(String s) {
        StringBuilder s2 = new StringBuilder(s);
        return s.equals(s2.reverse().toString());
    }
}
