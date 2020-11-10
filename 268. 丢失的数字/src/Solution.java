/**
 * @author CuiJunJie
 * @create 2020-11-10-10:29
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x ^= nums[i];
        }
        for (int i = 1; i <= nums.length; i++) {
            x ^= i;
        }

        return x;
    }
}
