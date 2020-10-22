/**
 * @author CuiJunJie
 * @create 2020-10-22-15:24
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(15, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            if (sum >= s) {
                while (sum - nums[i] >= s) {
                    sum -= nums[i];
                    i++;
                }
                minLen = Math.min(minLen, j - i + 1);
            }
            j++;
        }

        if (minLen == Integer.MAX_VALUE) {
            minLen = 0;
        }
        return minLen;
    }
}
