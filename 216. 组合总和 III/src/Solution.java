import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-10-28-14:42
 */
public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> ret = combinationSum3(9, 45);

        for (List<Integer> list : ret) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrace(k, n, new boolean[10], 0, 0, 1, ret, new ArrayList<Integer>());

        return ret;
    }

    public static void backtrace(int k, int n, boolean[] visited, int t, int sum, int start, List<List<Integer>> ret, List<Integer> list) {
        if (t > k) {
            return;
        }

        if (k == t && n == sum) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sum += i;
                if (sum > n) {
                    sum -= i;
                    visited[i] = false;
                    break;
                }
                list.add(i);
                backtrace(k, n, visited, t + 1, sum, i + 1, ret, list);
                list.remove(list.size() - 1);
                sum -= i;
                visited[i] = false;
            }
        }
    }
}
