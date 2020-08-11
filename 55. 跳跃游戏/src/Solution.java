/**
 * @author cuijunjie
 * @create 2020--11-14:16
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int maxAch = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (maxAch < i) {
                return false;
            } else if (maxAch >= nums.length - 1) {
                return true;
            }
            if (i + nums[i] > maxAch) {
                maxAch = i + nums[i];
            }
        }
        return maxAch >= nums.length - 1;
    }

//    public static boolean canJump(int[] nums) {
//        if (nums.length <= 1) {
//            return true;
//        }
//        boolean ret = true;
//        for (int i = nums.length - 2; i >= 0; i--) {
//            if (nums[i] == 0) {
//                ret = false;
//                for (int j = i - 1; j >= 0; j--) {
//                    if (nums[j] > i - j) {
//                        ret = true;
//                    }
//                }
//                if (ret == false) {
//                    return ret;
//                }
//            }
//        }
//        return ret;
//    }
}
