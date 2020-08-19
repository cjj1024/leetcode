import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--18-17:20
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ret = subsetsWithDup(nums);
        for (List<Integer> item : ret) {
            for (Integer x : item) {
                System.out.printf("%d ", x);
            }
            System.out.println();
        }
//        [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3],[3,2]]
//        [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        if (nums == null || nums.length < 1) {
            return ret;
        }
        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];
        ArrayList<Integer> tmp = new ArrayList<>(nums.length);
        backtrace(nums, 0, 0, used, ret, tmp);

        return ret;
    }

    public static void backtrace(int[] nums, int k, int len, boolean[] used, List<List<Integer>> ret, List<Integer> tmp) {
        if (len == nums.length) {
            return;
        }

        for (int i = k; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && !used[i - 1] && nums[i - 1] == nums[i]) {
                continue;
            }
            used[i] = true;
            tmp.add(nums[i]);
            ret.add(new ArrayList<>(tmp));
            backtrace(nums, i + 1, len + 1, used, ret, tmp);
            tmp.remove(len);
            used[i] = false;
        }
    }
}
