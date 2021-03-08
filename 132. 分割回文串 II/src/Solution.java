/**
 * @author CuiJunJie
 * @create 2020-09-10-16:16
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(minCut("cbbbcc"));
        System.out.println(minCut("aab"));
        System.out.println(minCut("ab"));
        System.out.println(minCut("a"));
        System.out.println(minCut("aaabaa"));
    }

    public static int minCut(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            dp[i] = i;
        }
        for (int i = 1; i < chars.length; i++) {
            if (isPalindrome(chars,0, i)) {
                dp[i] = 0;
                continue;
            }

            boolean flag = true;
            for (int j = 1; j < i; j++) {
                if (isPalindrome(chars, j, i)) {
                    flag = false;
                    dp[i] = Math.min(dp[j - 1] + 1, dp[i]);
                }
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }

        return dp[chars.length - 1];
    }

    private static boolean isPalindrome(char[] chars, int a, int b) {
        if ((b - a + 1) % 2 == 0) {
            int m = (b + a) / 2;
            for (int i = m, j = m + 1; i >= a && j <= b; i--, j++) {
                if (chars[i] != chars[j]) {
                    return false;
                }
            }

            return true;
        } else {
            int m = (b + a) / 2;
            for (int i = m - 1, j = m + 1; i >= a && j <= b; i--, j++) {
                if (chars[i] != chars[j]) {
                    return false;
                }
            }

            return true;
        }
    }

//    public static int minCut(String s) {
//
//        if (s == null || s.length() < 1) {
//            return 0;
//        }
//
//        char[] sChar = s.toCharArray();
//        int[] dp = new int[sChar.length];
//        for (int i = 0; i < sChar.length; i++) {
//            dp[i] = i;
//        }
//
//        for (int i = 0; i < sChar.length; i++) {
//            if (checkPalindrome(sChar, 0, i)) {
//                dp[i] = 0;
//            }
//
//            for (int j = 0; j < i; j++) {
//                if (checkPalindrome(sChar, j + 1, i)) {
//                    dp[i] = Math.min(dp[i], dp[j] + 1);
//                }
//            }
//        }
//
//        return dp[s.length() - 1];
//    }

    public static boolean checkPalindrome(char[] s, int left, int right) {
        while (left < right) {
            if (s[left] != s[right]) {
                return false;
            }
            ++left;
            --right;
        }

        return true;
    }
}
