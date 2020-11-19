/**
 * @author CuiJunJie
 * @create 2020-11-19-10:56
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
