/**
 * @author CuiJunJie
 * @create 2020-09-23-14:35
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

//    public static int findPeakElement(int[] nums) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] > nums[i + 1]) {
//                return i;
//            }
//        }
//
//        return nums.length - 1;
//    }

//    public static int findPeakElement(int[] nums) {
//        if (nums == null || nums.length < 1) {
//            return -1;
//        }
//
//        if (nums.length == 1) {
//            return 0;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (i == 0) {
//                if (nums[i] > nums[i + 1]) {
//                    return i;
//                }
//                continue;
//            }
//            if (i == nums.length - 1) {
//                if (nums[i] > nums[i - 1]) {
//                    return i;
//                }
//                continue;
//            }
//            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
}
