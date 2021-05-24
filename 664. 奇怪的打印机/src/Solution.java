/**
 * @author CuiJunJie
 * @create 2021/5/24-9:25
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(strangePrinter("aaabbb"));
        System.out.println(strangePrinter("aba"));
    }

    public static int strangePrinter(String s) {
        char[] sChars = s.toCharArray();
        int n = sChars.length;
        int[][] dp = new int[n][n];


        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (sChars[i] == sChars[j]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
