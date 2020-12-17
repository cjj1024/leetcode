/**
 * @author CuiJunJie
 * @create 2020/12/17-9:50
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }

    public static int maxProfit(int[] prices, int fee) {
        int[] dp1 = new int[prices.length];
        int[] dp2 = new int[prices.length];
        dp1[0] = 0;
        dp2[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp2[i - 1] + prices[i] - fee);
            dp2[i] = Math.max(dp2[i - 1], dp1[i - 1] - prices[i]);
        }

        return Math.max(dp1[prices.length - 1], dp2[prices.length - 1]);
    }
}
