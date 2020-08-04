/**
 * @author cuijunjie
 * @create 2020--04-16:30
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};

        System.out.println(removeDuplicates(nums));
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int ret = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[ret] != nums[i]) {
                nums[++ret] = nums[i];
            }
        }

        return ret + 1;
    }
}
