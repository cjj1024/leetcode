import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2020/12/5-15:57
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

//    public static int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length < 1) {
//            return 0;
//        }
//
//        return backtrace(nums, new Stack<>(), 0);
//    }
//
//    private static int backtrace(int[] nums, Stack<Integer> queue, int k) {
//        if (k >= nums.length) {
//            return queue.size();
//        }
//
//        int maxNum = 0;
//        for (int i = k; i < nums.length; i++) {
//            if (queue.isEmpty() || nums[i] > queue.peek()) {
//                queue.push(nums[i]);
//                maxNum = Math.max(maxNum, backtrace(nums, queue, i + 1));
//                queue.pop();
//            }
//            maxNum = Math.max(maxNum, backtrace(nums, queue, i + 1));
//        }
//
//        return maxNum;
//    }
}
