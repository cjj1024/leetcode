/**
 * @author cuijunjie
 * @create 2020--15-16:16
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int num = removeDuplicates(nums);
        System.out.println(num);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int n = 1;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                n++;
            } else {
                n = 1;
            }
            if (n > 2) {
                continue;
            }
            nums[k++] = nums[i];
        }

        return k;
    }

//    public static int removeDuplicates(int[] nums) {
//        if (nums.length < 2) {
//            return nums.length;
//        }
//        int count = 1;
//        int k = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[k] == nums[i]) {
//                count++;
//            } else {
//                count = 1;
//            }
//            if (count <= 2) {
//                nums[++k] = nums[i];
//            }
//        }
//
//        return ++k;
//    }
}
