import java.util.HashSet;

/**
 * @author CuiJunJie
 * @create 2020-11-03-10:04
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }

//    public static boolean containsNearbyDuplicate(int[] nums, int k) {
//        if (nums == null || nums.length < 1) {
//            return false;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 1; j <= k && i + j < nums.length; j++) {
//                if (nums[i] == nums[i + j]) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
}
