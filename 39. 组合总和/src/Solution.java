import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--07-14:24
 */
public class Solution {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(candidates, target);
        for (List list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        return backtrace(candidates, target, 0);
    }

    public static List<List<Integer>> backtrace(int[] candidates, int target, int begin) {
        if (target < 1) {
            return null;
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] == 0) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                ret.add(list);
            } else {
                List<List<Integer>> lists = backtrace(candidates, target - candidates[i], i);
                if (lists != null) {
                    for (List list : lists) {
                        list.add(candidates[i]);
                        ret.add(list);
                    }
                }
            }
        }

        return ret;
    }
}
