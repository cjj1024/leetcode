/**
 * @author CuiJunJie
 * @create 2020-09-02-15:17
 */
public class Solution {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }

        int dp10 = 0;
        int dp11 = Integer.MIN_VALUE;
        int dp20 = 0;
        int dp21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp20 = Math.max(dp20, dp21 + price);
            dp21 = Math.max(dp21, dp10 - price);
            dp10 = Math.max(dp10, dp11 + price);
            dp11 = Math.max(dp11, -price);
        }

        return dp20;
    }
}