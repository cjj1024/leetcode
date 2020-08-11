import java.util.Arrays;
import java.util.Collections;

/**
 * @author cuijunjie
 * @create 2020--11-9:34
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        return get(nums, 0, nums.length - 1).mSum;
    }

    public static Status get(int[] nums, int l, int r) {
        if (l == r) {
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = get(nums, l, m);
        Status rSub = get(nums, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public static Status pushUp(Status lSub, Status rSub) {
        int iSum = lSub.iSum + rSub.iSum;
        int lSum = Math.max(lSub.lSum, lSub.iSum + rSub.lSum);
        int rSum = Math.max(rSub.rSum, rSub.iSum + lSub.rSum);
        int mSum = Math.max(Math.max(lSub.mSum, rSub.mSum), lSub.rSum + rSub.lSum);

        return new Status(lSum, rSum, mSum, iSum);
    }

    static class Status {
        int lSum;
        int rSum;
        int mSum;
        int iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

//    public static int maxSubArray(int[] nums) {
//        if (nums.length < 1) {
//            return 0;
//        }
//
//        int pre = 0;
//        int ret = Integer.MIN_VALUE;
//        for (int x : nums) {
//            pre = Math.max(pre + x, x);
//            ret = Math.max(pre, ret);
//        }
//
//        return ret;
//    }

//    public static int maxSubArray(int[] nums) {
//        if (nums.length < 1) {
//            return 0;
//        }
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (dp[i - 1] + nums[i] > nums[i]) {
//                dp[i] = dp[i - 1] + nums[i];
//            } else {
//                dp[i] = nums[i];
//            }
//        }
//
//        return Arrays.stream(dp).max().getAsInt();
//    }

//    public static int maxSubArray(int[] nums) {
//        if (nums.length < 1) {
//            return 0;
//        }
//        int ret = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            int sum = nums[i];
//            ret = Math.max(ret, sum);
//            for (int j = i + 1; j < nums.length; j++) {
//                sum += nums[j];
//                ret = Math.max(ret, sum);
//            }
//        }
//
//        return ret;
//    }
}
