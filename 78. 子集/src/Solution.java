import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--15-15:12
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> subset : subsets) {
            for (Integer integer : subset) {
                System.out.printf("%d ", integer);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null) {
            return null;
        }
        ret.add(new ArrayList<>());
        if (nums.length < 1) {
            return ret;
        }

        ArrayList<Integer> list = new ArrayList<>();
        backtrace(nums, 0, list, ret);

        return ret;
    }

    public static void backtrace(int[] nums, int k, List<Integer> list, List<List<Integer>> ret) {
        if (k == nums.length) {
            return;
        }

        for (int i = k; i < nums.length; i++) {
            list.add(nums[i]);
            ArrayList<Integer> newList = new ArrayList<>(list);
            ret.add(newList);
            backtrace(nums, i + 1, list, ret);
            list.remove(list.size() - 1);
        }
    }
}
