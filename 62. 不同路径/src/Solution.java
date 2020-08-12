/**
 * @author cuijunjie
 * @create 2020--12-17:21
 */
public class Solution {
    public static void main(String[] args) {
        int num = uniquePaths(7, 3);
        System.out.println(num);
    }


    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m ; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }


//    public static int uniquePaths(int m, int n) {
//        if (m == 0 || n == 0) {
//            return 0;
//        }
//        return recursion(m, n, 1, 1);
//    }
//
//    public static int recursion(int m, int n, int i, int j) {
//        if (m == i || n == j) {
//            return 1;
//        }
//        int num = 0;
//        num += recursion(m, n, i + 1, j);
//        num += recursion(m, n, i, j + 1);
//
//        return num;
//    }
}
