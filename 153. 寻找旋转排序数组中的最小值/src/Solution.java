/**
 * @author CuiJunJie
 * @create 2020-09-22-11:08
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) >> 1;
        while (left < right) {
            mid = (left + right) >> 1;

            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }
}
