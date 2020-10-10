/**
 * @author CuiJunJie
 * @create 2020-09-30-11:06
 */
public class Solution {
    public static void main(String[] args) {
        int[] prices = {2, 4, 1};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }

    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }

        int n = prices.length;
        if (k >= n / 2) {
            int dp0 = 0;
            int dp1 = -prices[0];
            for (int i = 1; i < n; i++) {
                int t = dp0;
                dp0 = Math.max(dp0, dp1 + prices[i]);
                dp1 = Math.max(dp1, t - prices[i]);
            }
            return dp0;
        }

        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j > 0; j--) {
                dp[j - 1][1] = Math.max(dp[j - 1][1], dp[j - 1][0] - prices[i]);
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] + prices[i]);
            }
        }

        return dp[k][0];
    }
}
