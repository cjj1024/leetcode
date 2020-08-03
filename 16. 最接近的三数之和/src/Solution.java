import java.util.Arrays;

/**
 * @author cuijunjie
 * @create 2020--03-15:50
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0,2,1,-3};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sumClosest = 0;
        double minDiff = 10e4;

        double diff = 0;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if ((sum = nums[i] + nums[j] + nums[k]) < target) {
                    j++;
                } else {
                    k--;
                }
                if ((diff = Math.abs(sum - target)) < minDiff) {
                    minDiff = diff;
                    sumClosest = sum;
                }
            }

        }

        return sumClosest;
    }
}
