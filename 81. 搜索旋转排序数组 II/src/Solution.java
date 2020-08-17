/**
 * @author cuijunjie
 * @create 2020--15-16:48
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 1, 1};
        System.out.println(search(nums, 0));
    }

    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return true;
            } else if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
