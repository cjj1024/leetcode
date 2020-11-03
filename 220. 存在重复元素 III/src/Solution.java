import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author CuiJunJie
 * @create 2020-11-03-10:14
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2147483640,2147483641};
        int k = 1, t = 100;

        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null) {
            return false;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] <= (long) floor + t) {
                return true;
            }
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && nums[i] + t >= (long)  ceiling) {
                return true;
            }

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }


//    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        if (nums == null) {
//            return false;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 1; j <= k && i + j < nums.length; j++) {
//                if (Math.abs(nums[i] - nums[i + j]) <= t) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
}
