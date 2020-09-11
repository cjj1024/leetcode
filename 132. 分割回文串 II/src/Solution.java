/**
 * @author CuiJunJie
 * @create 2020-09-10-16:16
 */
public class Solution {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));
    }

    public static int minCut(String s) {

        if (s == null || s.length() < 1) {
            return 0;
        }

        char[] sChar = s.toCharArray();
        int[] dp = new int[sChar.length];
        for (int i = 0; i < sChar.length; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < sChar.length; i++) {
            if (checkPalindrome(sChar, 0, i)) {
                dp[i] = 0;
            }

            for (int j = 0; j < i; j++) {
                if (checkPalindrome(sChar, j + 1, i)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[s.length() - 1];
    }

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
