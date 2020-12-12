import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020/12/12-9:54
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
    }

    public static int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int[] up = new int[nums.length];
        Arrays.fill(up, 1);
        int[] down = new int[nums.length];
        Arrays.fill(down, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                }
                if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
        }

        return Math.max(Arrays.stream(up).max().getAsInt(), Arrays.stream(down).max().getAsInt());
    }

//    public static int wiggleMaxLength(int[] nums) {
//        if (nums == null || nums.length < 1) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return 1;
//        }
//
//        List<Integer> list = new ArrayList<>(nums.length);
//        return Math.max(helper(nums, list, 0, true), helper(nums, list, 0, false));
//    }
//
//    private static int helper(int[] nums, List<Integer> list, int k, boolean comp) {
//        if (k >= nums.length) {
//            return list.size();
//        }
//
//        int maxLen = 0;
//        for (int i = k; i < nums.length; i++) {
//            if (list.isEmpty()) {
//                list.add(nums[i]);
//                maxLen = Math.max(maxLen, helper(nums, list, i + 1, comp));
//                list.remove(list.size() - 1);
//                maxLen = Math.max(maxLen, helper(nums, list, i+ 1, comp));
//            } else {
//                if ((comp && nums[i] > list.get(list.size() - 1)) || (!comp && nums[i] < list.get(list.size() -1))) {
//                    list.add(nums[i]);
//                    maxLen = Math.max(maxLen, helper(nums, list, i + 1, !comp));
//                    list.remove(list.size() - 1);
//                    maxLen = Math.max(maxLen, helper(nums, list, i + 1, comp));
//                }
//            }
//        }
//
//        return maxLen;
//    }
}
