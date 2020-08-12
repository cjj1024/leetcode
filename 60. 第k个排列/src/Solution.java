import java.util.ArrayList;
import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--12-11:33
 */
public class Solution {
    public static void main(String[] args) {
        String ret = getPermutation(5, 1);
        System.out.println(ret);
    }

    public static String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        boolean[] used = new boolean[nums.length];
        StringBuffer sb = new StringBuffer();
        return dfs(nums, used, sb, n, 0, k);
    }

    public static String dfs(int[] nums, boolean[] used, StringBuffer sb, int n, int k, int num) {
        if (k == n) {
            return sb.toString();
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            int cur = factorial(n - k - 1);
            if (cur < num) {
                num -= cur;
                continue;
            }
            sb.append(nums[i]);
            used[i] = true;
            return dfs(nums, used, sb, n, k + 1, num);
        }

        return null;
    }

    static int factorial(int n) {
        int res = 1;
        while (n > 0) {
            res *= n--;
        }
        return res;
    }
}

