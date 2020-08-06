/**
 * @author cuijunjie
 * @create 2020--06-17:09
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 4;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid -  1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

//    public static int searchInsert(int[] nums, int target) {
//        if (nums.length < 1) {
//            return 0;
//        }
//        int i = 0;
//        while (i < nums.length && nums[i] < target) {
//            ++i;
//        }
//
//        return i;
//    }
}
