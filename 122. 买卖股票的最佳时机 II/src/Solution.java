/**
 * @author CuiJunJie
 * @create 2020-09-02-14:55
 */
public class Solution {
    public static void main(String[] args) {
        int[] prices = {1,9,6,9,1,7,1,1,5,9,9,9};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }

        int minPrice = prices[0];
        int profit = 0;
        int ret = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                minPrice = prices[i];
                ret += profit;
                profit = 0;
            } else {
                profit = Math.max(profit, prices[i] - minPrice);
            }
        }
        if (prices.length > 1 && prices[prices.length - 1] >= prices[prices.length - 2]) {
            ret += profit;
        }

        return ret;
    }
}
