/**
 * @author CuiJunJie
 * @create 2020-10-17-9:50
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = second;
            second = Math.max(second, first + nums[i]);
            first = tmp;
        }

        return second;
    }

//    public static int rob(int[] nums) {
//        if (nums == null || nums.length < 1) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        if (nums.length == 2) {
//            return Math.max(nums[0], nums[1]);
//        }
//
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//        }
//
//        return dp[nums.length - 1];
//    }
}
