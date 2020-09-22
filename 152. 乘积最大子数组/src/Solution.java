/**
 * @author CuiJunJie
 * @create 2020-09-22-10:26
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {-2, 3, -4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int minP = nums[0];
        int maxP = nums[0];
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int t1 = maxP;
            int t2 = minP;
            maxP = Math.max(nums[i], Math.max(t1 * nums[i], t2 * nums[i]));
            minP = Math.min(nums[i], Math.min(t1 * nums[i], t2 * nums[i]));

            ret = Math.max(ret, maxP);
        }

        return ret;
    }
}
