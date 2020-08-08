/**
 * @author cuijunjie
 * @create 2020--08-15:53
 */
public class Solution {
    public static void main(String[] args) {
        String s = "";
        String p = "a";

        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        int sLen = sChars.length;
        int pLen = pChars.length;
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];

        dp[0][0] = true;
        for (int i = 0; i < pLen; i++) {
            if (pChars[i] == '*') {
                dp[0][i + 1] = true;
            } else {
                break;
            }
        }
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < pLen; j++) {
                if (sChars[i] == pChars[j] || pChars[j] == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (pChars[j] == '*') {
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
                }
            }
        }

        return dp[sLen][pLen];
    }
}
