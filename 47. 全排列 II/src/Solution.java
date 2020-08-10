import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--10-10:26
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);
        lists.forEach(System.out::println);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret  = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(nums, ret, new ArrayList<>(), new boolean[nums.length], 0);

        return ret;
    }

    public static void backtrace(int[] nums, List<List<Integer>> ret, List<Integer> list, boolean[] used, int i) {
        if (i == nums.length) {
            ArrayList<Integer> newList = new ArrayList<>(list);
            ret.add(newList);
        }

        for (int j = 0; j < nums.length; j++) {
            if (used[j]) {
                continue;
            }
            if (j > 0 && nums[j] == nums[j - 1] && !used[j - 1]) {
                continue;
            }
            list.add(nums[j]);
            used[j] = true;
            backtrace(nums, ret, list, used, i + 1);
            list.remove(i);
            used[j] = false;
        }
    }
}
