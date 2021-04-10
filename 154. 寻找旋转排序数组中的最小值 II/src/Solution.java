import java.util.PriorityQueue;

/**
 * @author CuiJunJie
 * @create 2020-09-22-11:28
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1};
        System.out.println(findMin(nums));
        System.out.println(findMin(new int[]{1, 3, 5}));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (right - left) / 2 + left;
        while (left <= right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            mid = (right - left) / 2 + left;
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                left++;
            }
        }

        return nums[right];
    }

//    public static int findMin(int[] nums) {
//        int left = 0;
//        int right = nums.length - 1;
//        int mid;
//        while (left < right) {
//            mid = (left + right) >> 1;
//            if (nums[mid] < nums[right]) {
//                right = mid;
//            } else if (nums[mid] > nums[right]) {
//                left = mid + 1;
//            } else {
//                right -= 1;
//            }
//        }
//
//        return nums[left];
//    }
}
