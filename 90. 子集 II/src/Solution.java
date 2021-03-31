import java.util.*;

/**
 * @author cuijunjie
 * @create 2020--18-17:20
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> ret = subsetsWithDup(nums);
        for (List<Integer> item : ret) {
            for (Integer x : item) {
                System.out.printf("%d ", x);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        backtrace(nums, ret, new ArrayList<>(), 0);

        return ret;
    }

    private static void backtrace(int[] nums, List<List<Integer>> ret, ArrayList<Integer> list, int start) {
        ret.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backtrace(nums, ret, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

//    public static List<List<Integer>> subsetsWithDup(int[] nums) {
//        Arrays.sort(nums);
//
//        List<List<Integer>> ret = new ArrayList<>();
//        backtrace(ret, nums, 0, new ArrayList<>(), false);
//
//        return ret;
//    }
//
//    public static void backtrace(List<List<Integer>> ret, int[] nums, int k, List<Integer> list, boolean used) {
//        if (k == nums.length) {
//            ret.add(new ArrayList<>(list));
//            return;
//        }
//
//        if (k > 0 && nums[k] == nums[k - 1] && !used) {
//            backtrace(ret, nums, k + 1, list, false);
//        } else {
//            list.add(nums[k]);
//            backtrace(ret, nums, k + 1, list, true);
//            list.remove(list.size() - 1);
//            backtrace(ret, nums, k + 1, list, false);
//        }
//    }



//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        Arrays.sort(nums);
//
//        Map<String, List<Integer>> map = new HashMap<>();
//        backtrace(map, nums, 0, new ArrayList<>());
//
//        List<List<Integer>> ret = new ArrayList<>();
//        for (String s : map.keySet()) {
//            ret.add(map.get(s));
//        }
//
//        return ret;
//    }
//
//    public void backtrace(Map<String, List<Integer>> ret, int[] nums, int k, List<Integer> list) {
//        if (k == nums.length) {
//            ret.put(list.toString(), new ArrayList<>(list));
//            return;
//        }
//
//        list.add(nums[k]);
//        backtrace(ret, nums, k + 1, list);
//        list.remove(list.size() - 1);
//        backtrace(ret, nums, k + 1, list);
//
//    }
//
//    public static List<List<Integer>> subsetsWithDup(int[] nums) {
//        List<List<Integer>> ret = new ArrayList<>();
//        ret.add(new ArrayList<>());
//        if (nums == null || nums.length < 1) {
//            return ret;
//        }
//        Arrays.sort(nums);
//
//        boolean[] used = new boolean[nums.length];
//        ArrayList<Integer> tmp = new ArrayList<>(nums.length);
//        backtrace(nums, 0, 0, used, ret, tmp);
//
//        return ret;
//    }
//
//    public static void backtrace(int[] nums, int k, int len, boolean[] used, List<List<Integer>> ret, List<Integer> tmp) {
//        if (len == nums.length) {
//            return;
//        }
//
//        for (int i = k; i < nums.length; i++) {
//            if (used[i]) {
//                continue;
//            }
//            if (i > 0 && !used[i - 1] && nums[i - 1] == nums[i]) {
//                continue;
//            }
//            used[i] = true;
//            tmp.add(nums[i]);
//            ret.add(new ArrayList<>(tmp));
//            backtrace(nums, i + 1, len + 1, used, ret, tmp);
//            tmp.remove(len);
//            used[i] = false;
//        }
//    }
}
