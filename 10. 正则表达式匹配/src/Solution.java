/**
 * @author cuijunjie
 * @create 2020--01-11:00
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isMatch("mississippi",  "mis*is*p*."));
    }

    public static boolean isMatch(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int m = sArr.length;
        int n = pArr.length;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pArr[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (myMatch(sArr, pArr, i, j - 1)) {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                } else {
                    if (myMatch(sArr, pArr, i,  j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static boolean myMatch(char[] sArr, char[] pArr, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (pArr[j - 1] == '.') {
            return true;
        }
        if (sArr[i - 1] == pArr[j - 1]) {
            return true;
        }

        return false;
    }
}
