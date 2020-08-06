/**
 * @author cuijunjie
 * @create 2020--05-18:49
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        nextPermutation(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            --i;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                --j;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        for (int left = i + 1, right = nums.length - 1; left <= right; ++left, --right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }
}
