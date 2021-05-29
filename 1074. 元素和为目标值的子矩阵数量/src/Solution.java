import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2021/5/29-11:07
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(numSubmatrixSumTarget(new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, 0)); // 4
        System.out.println(numSubmatrixSumTarget(new int[][]{{1, -1}, {-1, 1}}, 0)); // 5
    }

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int num = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k <= m; k++) {
                    Arrays.fill(dp[k], 0);
                }
                for (int p = i; p <= m; p++) {
                    for (int q = j; q <= n; q++) {
                        dp[p][q] = dp[p][q - 1] + dp[p - 1][q] - dp[p - 1][q - 1] + matrix[p - 1][q - 1];
                        if (dp[p][q] == target) {
                            num++;
                        }
//                        System.out.println(dp[p][q]);
                    }
                }
            }
        }

        return num;
    }

//    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int[][][][] dp = new int[m + 1][n + 1][m + 1][n + 1];
//
//        int num = 0;
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                for (int p = i; p <= m; p++) {
//                    for (int q = j; q <= n; q++) {
//                        dp[i][j][p][q] = dp[i][j][p][q - 1] + dp[i][j][p - 1][q] - dp[i][j][p - 1][q - 1] + matrix[p - 1][q - 1];
//                        if (dp[i][j][p][q] == target) {
//                            num++;
//                        }
////                        System.out.println(dp[i][j][p][q]);
//                    }
//                }
//            }
//        }
//
//        return num;
//    }
}
