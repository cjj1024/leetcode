import java.util.ArrayList;
import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--15-14:31
 */
public class Solution {
    public static void main(String[] args) {
        int  n = 4, k = 2;

        List<List<Integer>> combine = combine(n, k);
        for (List<Integer> integers : combine) {
            for (Integer integer : integers) {
                System.out.printf("%d ", integer);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if (n < k || n <= 0 || k <= 0) {
            return ret;
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        ArrayList<Integer> list = new ArrayList<>();
        backtrace(nums, k, 0, 0, list, ret);

        return ret;
    }

    public static void backtrace(int[] nums, int k, int len, int first, List<Integer> list, List<List<Integer>> ret) {
        if (k == len) {
            ArrayList<Integer> newList = new ArrayList<>(list);
            ret.add(newList);
            return;
        }

        for (int i = first; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace(nums, k, len + 1, i + 1, list, ret);
            list.remove(len);
        }
    }
}
