import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2021/4/24-9:35
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
    }

    public static int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);

//        return backtrace(nums, target, 0);
//        map = new HashMap<>();
//        return divide(nums, target);

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                }
                dp[i] += dp[i - num];
            }
        }

        return dp[target];
    }

    private static Map<Integer, Integer> map;
    private static int divide(int[] nums, int target) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }

        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num += divide(nums, target - nums[i]);
        }

        map.put(target, num);
        return num;
    }

    private static int backtrace(int[] nums, int target, int sum) {
        if (sum == target) {
            return 1;
        }
        if (sum > target) {
            return 0;
        }

        int num = 0;

        for (int i = 0; i < nums.length; i++) {
            num += backtrace(nums, target, sum + nums[i]);
        }

        return num;
    }
}
