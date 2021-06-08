/**
 * @author CuiJunJie
 * @create 2021/6/8-9:35
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(lastStoneWeightII(new int[]{2,7,4,1,8,1}));
    }

    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int n = stones.length;
        int[][] dp = new int[n + 1][sum / 2 + 1];
        for (int i = 1; i <= n; i++) {
            int w = stones[i - 1];
            for (int j = 0; j <= sum / 2; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + w);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return sum - 2 * dp[n][sum / 2];
    }

//    private static int minWeight = Integer.MAX_VALUE;
//    private static int remain = 0;
//    public static int lastStoneWeightII(int[] stones) {
//        minWeight = Integer.MAX_VALUE;
//        remain = stones.length;
//
//        backtrace(stones, new boolean[remain]);
//
//        return minWeight;
//    }
//
//    private static void backtrace(int[] stones, boolean[] used) {
//        if (remain <= 1) {
//            if (remain == 0) {
//                minWeight = 0;
//            } else {
//                for (int i = 0; i < stones.length; i++) {
//                    if (!used[i]) {
//                        minWeight = Math.min(minWeight, stones[i]);
//                        break;
//                    }
//                }
//            }
//            return;
//        }
//
//        for (int i = 0; i < stones.length; i++) {
//            if (used[i]) {
//                continue;
//            }
//            for (int j = 0; j < stones.length; j++) {
//                if (used[j] || i == j) {
//                    continue;
//                }
//                int diff = 0;
//                if (stones[i] > stones[j]) {
//                    diff = stones[j];
//                    stones[i] -= diff;
//                    stones[j] = 0;
//                    used[j] = true;
//                    remain--;
//                    backtrace(stones, used);
//                    stones[i] += diff;
//                    stones[j] = diff;
//                    used[j] = false;
//                    remain++;
//                } else if (stones[i] < stones[j]){
//                    diff = stones[i];
//                    stones[i] = 0;
//                    stones[j] -= diff;
//                    used[i] = true;
//                    remain--;
//                    backtrace(stones, used);
//                    stones[i] = diff;
//                    stones[j] += diff;
//                    used[i] = false;
//                    remain++;
//                } else {
//                    diff = stones[i];
//                    stones[i] = 0;
//                    stones[j] = 0;
//                    remain -= 2;
//                    used[i] = true;
//                    used[j] = true;
//                    backtrace(stones, used);
//                    stones[i] = diff;
//                    stones[j] = diff;
//                    used[i] = false;
//                    used[j] = false;
//                    remain += 2;
//                }
//            }
//        }
//    }
}
