import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-09-02-14:13
 */
public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 7));
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1) {
            return 0;
        }

        int m = triangle.size();
        int n = 0;
        for (List<Integer> integers : triangle) {
            n = Math.max(n, integers.size());
        }

        int[][] dp = new int[m][n];

        List<Integer> list = triangle.get(0);
        for (int j = 0; j < triangle.get(0).size(); j++) {
            dp[0][j] = list.get(j);
        }
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
        }
        for (int i = 1; i < triangle.size(); i++) {
            list = triangle.get(i);
            dp[i][list.size() - 1] = list.get(list.size() - 1) + dp[i - 1][list.size() - 2];
        }
        for (int i = 1; i < m; i++) {
            list = triangle.get(i);
            for (int j = 1; j < list.size() - 1; j++) {
                dp[i][j] = list.get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }

        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}
