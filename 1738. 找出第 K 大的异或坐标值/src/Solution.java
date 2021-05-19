import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * @author CuiJunJie
 * @create 2021/5/19-9:39
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1));
        System.out.println(kthLargestValue(new int[][]{{10, 9, 5}, {2, 0, 4}, {1, 0, 9}, {3, 4, 8}}, 10));
    }

    public static int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j - 1] ^ dp[i - 1][j] ^ dp[i][j - 1] ^ matrix[i - 1][j - 1];
                list.add(dp[i][j]);
            }
        }

        Collections.sort(list, ((o1, o2) -> o2 - o1));

        return list.get(k - 1);
    }
}
