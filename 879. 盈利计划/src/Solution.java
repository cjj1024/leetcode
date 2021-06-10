/**
 * @author CuiJunJie
 * @create 2021/6/9-15:58
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3}));
        System.out.println(profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
    }


    private static int num = 0;
    private static int mod = 1000000000 + 7;
    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        num = 0;

        backtrace(n, minProfit, group, profit, 0, 0);

        return num;
    }

    private static void backtrace(int n, int minProfit, int[] group, int[] profit, int k, int p) {
        if (k == group.length) {
            if (p >= minProfit) {
                num++;
                if (num == mod) {
                    num = 0;
                }
            }
            return;
        }

        if (group[k] <= n) {
            backtrace(n - group[k], minProfit, group, profit, k + 1, p + profit[k]);
        }
        backtrace(n, minProfit, group, profit, k + 1, p);


    }
}
