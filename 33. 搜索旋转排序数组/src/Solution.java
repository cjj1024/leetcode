/**
 * @author cuijunjie
 * @create 2020--06-15:08
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        for(int target : nums) {
            System.out.println(search(nums, target));
        }
        System.out.println(search(nums, 99));
    }

    public static int search(int[] nums, int target) {
        if (nums.length < 1) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return target == nums[mid] ? mid : -1;
    }
}
