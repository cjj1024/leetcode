/**
 * @author CuiJunJie
 * @create 2020-09-02-14:50
 */
public class Solution {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int minPrice = prices[0];
        int ret = 0;
        for (int i = 1; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                ret = Math.max(ret, prices[i] - minPrice);
            }
        }

        return ret;
    }
}
