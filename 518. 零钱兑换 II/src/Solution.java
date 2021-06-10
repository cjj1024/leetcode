import org.junit.Test;

/**
 * @author CuiJunJie
 * @create 2021/6/10-9:24
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1, 2, 5}));       // 4
        System.out.println(change(0, new int[]{7}));             // 1
        System.out.println(change(2, new int[]{2}));             // 1
        System.out.println(change(500, new int[]{1, 2, 5}));        // 12701
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

//    public static int change(int amount, int[] coins) {
//        if (amount == 0) {
//            return 1;
//        }
//
//        int n = coins.length;
//        int[][] dp = new int[n + 1][amount + 1];
//
//        for (int i = 1; i <= n; i++) {
//            int c = coins[i - 1];
//            for (int j = 1; j <= amount; j++) {
//                if (j % c == 0) {
//                    dp[i][j] = 1;
//                }
//                for (int k = 0; ; k++) {
//                    if (j - k * c >= 0) {
//                        dp[i][j] += dp[i - 1][j - k * c];
//                    } else {
//                        break;
//                    }
//                }
//            }
//        }
//
//        int num = 0;
//        for (int i = 0; i <= n; i++) {
//            num += dp[i][amount];
//        }
//
//        return dp[n][amount];
//    }
}
