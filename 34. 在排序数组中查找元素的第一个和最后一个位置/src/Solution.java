/**
 * @author cuijunjie
 * @create 2020--06-16:30
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int target = 1;

        int[] ret = searchRange(nums, target);
        for (int i : ret) {
            System.out.println(i);
        }
    }

    public static int[] searchRange(int[] nums, int target) {

        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;
        if (nums.length < 1) {
            return ret;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                while (nums[left] != target) {
                    left = left + 1;
                }
                while (nums[right] != target) {
                    right = right - 1;
                }
                ret[0] = left;
                ret[1] = right;
                return ret;
            }
        }

        return ret;
    }
}
