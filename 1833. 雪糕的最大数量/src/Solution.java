import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2021/7/2-9:59
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxIceCream(new int[]{1,3,2,4,1}, 7));   // 4
        System.out.println(maxIceCream(new int[]{10,6,8,7,7,8}, 5));    // 0
        System.out.println(maxIceCream(new int[]{1,6,3,1,2,5}, 20));   // 6
        System.out.println(maxIceCream(new int[]{27,23,33,26,46,86,70,85,89,82,57,66,42,18,18,5,46,56,
                42,82,52,78,4,27,96,74,74,52,2,24,78,18,42,10,12,10,80,30,60,38,32,7,98,26,18,62,50,42,
                15,14,32,86,93,98,47,46,58,42,74,69,51,53,58,40,66,46,65,2,10,82,94,26,6,78,2,101,97,16,
                12,18,71,5,46,22,58,12,18,62,61,51,2,18,34,12,36,58,20,12,17,70}, 241));    // 24
    }

    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int num = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins >= costs[i]) {
                num++;
                coins -= costs[i];
            } else {
                break;
            }
        }

        return num;
    }

//    public static int maxIceCream(int[] costs, int coins) {
//        int[][] dp = new int[costs.length + 1][coins + 1];
//
//        Arrays.sort(costs);
//        for (int i = 1; i <= costs.length; i++) {
//            int cost = costs[i - 1];
//            for (int j = 1; j <= coins; j++) {
//                if (j < cost) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + 1);
//                }
//            }
//        }
//
//        return dp[costs.length][coins];
//    }
}
