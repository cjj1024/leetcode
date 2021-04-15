import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2020-10-24-17:18
 */
public class Solution {
    public static void main(String[] args) {
//        int[] nums = {2,3,2};
//        System.out.println(rob(nums));
//
//        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{1}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int maxValue = 0;
        int[] dp = new int[nums.length + 2];
        Arrays.fill(dp, 0);

        for (int i = 0; i < nums.length - 1; i++) {
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + nums[i]);
        }
        maxValue = Math.max(maxValue, Arrays.stream(dp).max().getAsInt());

        Arrays.fill(dp, 0);
        for (int i = 1; i < nums.length; i++) {
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + nums[i]);
        }
        maxValue = Math.max(maxValue, Arrays.stream(dp).max().getAsInt());

        return maxValue;
    }

//    public static int rob(int[] nums) {
//        if (nums == null || nums.length < 1) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        return Math.max(rob2(Arrays.copyOfRange(nums, 0, nums.length - 1)), rob2(Arrays.copyOfRange(nums, 1, nums.length)));
//    }
//
//    public static int rob2(int[] nums) {
//        if (nums == null || nums.length < 1) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//
//        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//        }
//
//        return dp[nums.length - 1];
//    }
}
