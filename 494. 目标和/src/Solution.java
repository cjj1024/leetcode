/**
 * @author CuiJunJie
 * @create 2021/6/7-9:28
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
//        System.out.println(findTargetSumWays(new int[]{1}, 1));
        System.out.println(findTargetSumWays(new int[]{1000}, 1000));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 == 1) {
            return 0;
        }

        int add = diff / 2;
        int[][] dp = new int[nums.length + 1][add + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= add; j++) {
                dp[i][j] += dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }

        return dp[nums.length][add];
    }

//    private static int targetSumWays = 0;
//    public static int findTargetSumWays(int[] nums, int target) {
//        targetSumWays = 0;
//        backtrace(nums, target, 0, 0);
//
//        return targetSumWays;
//    }
//
//    private static void backtrace(int[] nums, int target, int sum, int k) {
//        if (k == nums.length) {
//            if (sum == target) {
//                targetSumWays++;
//            }
//            return;
//        }
//
//        backtrace(nums, target, sum + nums[k], k + 1);
//        backtrace(nums, target, sum - nums[k], k + 1);
//    }
}
