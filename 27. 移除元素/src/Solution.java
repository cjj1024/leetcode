/**
 * @author cuijunjie
 * @create 2020--04-16:36
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ret++] = nums[i];
            }
        }

        return ret;
    }
}
