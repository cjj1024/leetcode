import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020-11-03-10:14
 */
public class Solution {
    public static void main(String[] args) {
//        int[] nums = {2147483640,2147483641};
//        int k = 1, t = 100;
//
//        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));

        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));  // true
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2)); // true
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));  // false
        System.out.println(containsNearbyAlmostDuplicate(new int[]{-2147483648,2147483647}, 1, 1));  // false
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long c = set.ceiling((long) nums[i]);
            Long f = set.floor((long) nums[i]);
            if (c != null && c - nums[i] <= t) {
                return true;
            }
            if (f != null && nums[i] - f <= t) {
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }

        return false;
    }

//    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length && j - i <= k; j++) {
//                if (Math.abs((long) nums[i] - nums[j]) <= t) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }

//    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        if (nums == null) {
//            return false;
//        }
//
//        TreeSet<Integer> set = new TreeSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            Integer floor = set.floor(nums[i]);
//            if (floor != null && nums[i] <= (long) floor + t) {
//                return true;
//            }
//            Integer ceiling = set.ceiling(nums[i]);
//            if (ceiling != null && nums[i] + t >= (long)  ceiling) {
//                return true;
//            }
//
//            set.add(nums[i]);
//            if (set.size() > k) {
//                set.remove(nums[i - k]);
//            }
//        }
//
//        return false;
//    }


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
