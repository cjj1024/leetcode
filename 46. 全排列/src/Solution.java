import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--10-9:50
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        List<List<Integer>> list = permute(nums);
        list.forEach(System.out::println);
    }

    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 1) {
            return ret;
        }

        backtrace(ret, nums, 0, new ArrayList<Integer>(), new boolean[nums.length]);

        return ret;
    }

    public static void backtrace(ArrayList<List<Integer>> ret, int[] nums, int i, List<Integer> list, boolean[] used) {
        if (i == nums.length) {
            ArrayList<Integer> newList = new ArrayList<>(list);
            ret.add(newList);
        }
        for (int j = 0; j < nums.length; j++) {
            if (used[j]) {
                continue;
            }
            list.add(nums[j]);
            used[j] = true;
            backtrace(ret, nums, i + 1, list, used);
            list.remove(i);
            used[j] = false;
        }
    }
}
