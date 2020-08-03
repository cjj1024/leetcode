import java.util.*;

/**
 * @author cuijunjie
 * @create 2020--03-10:44
 */
public class Solution {
    public static void main(String[] args) {
        // -4 -1 -1 0 1 2
        int[] nums = new int[]{3,-2,1,0};
        long start = System.currentTimeMillis();
        System.out.println(threeSum(nums));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (k > j + 1 && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                if (k > j && nums[i] + nums[j] + nums[k] == 0) {
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }

        return ret;
    }

//    public static List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> ret = new ArrayList<>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                if (j > i + 1 && nums[j] == nums[j - 1]) {
//                    continue;
//                }
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (k > j + 1 && nums[k] == nums[k - 1]) {
//                        continue;
//                    }
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    }
//                }
//            }
//        }
//
//        return ret;
//    }
}
