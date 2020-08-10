/**
 * @author cuijunjie
 * @create 2020--08-17:01
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};

        System.out.println(jump(nums));
    }


    public static int jump(int[] nums) {
        int len = nums.length;
        int step = 0;
        int end = 0;
        int maxDist = 0;
        for (int i = 0; i < len - 1; i++) {
            maxDist = Math.max(maxDist, nums[i] + i);
            if (end == i) {
                end = maxDist;
                step++;
            }
        }

        return step;
    }

//    public static int jump(int[] nums) {
//        int len = nums.length;
//        int[] dp = new int[len];
//        for (int i = len - 2; i >= 0; i--) {
//            if (nums[i] < len - i - 1) {
//                int step = len;
//                for (int j = 1; j + i < len && j <= nums[i]; j++) {
//                    if (step > dp[j + i]) {
//                        step = dp[j + i];
//                    }
//                }
//                dp[i] = step + 1;
//            } else {
//                dp[i] = 1;
//            }
//        }
//
//        return dp[0];
//    }
}
