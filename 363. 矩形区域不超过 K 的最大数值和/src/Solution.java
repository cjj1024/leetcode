import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2021/4/22-9:25
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));  // 2
        System.out.println(maxSumSubmatrix(new int[][]{{2, 2, -1}}, 0)); // -1
        System.out.println(maxSumSubmatrix(new int[][]{{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}}, 10));  // 10
        System.out.println(maxSumSubmatrix(new int[][]{{2, 2, -1}}, 3)); //3
        System.out.println(maxSumSubmatrix(new int[][]{{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}}, 8));  // 8
    }

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];

        int diff = Integer.MAX_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int t = 0; t <= m; t++) {
                    Arrays.fill(sum[t], 0);
                }
                sum[i][j] = matrix[i - 1][j - 1];
                for (int p = i; p <= m; p++) {
                    for (int q = j; q <= n; q++) {
                        sum[p][q] = sum[p - 1][q] + sum[p][q - 1] - sum[p - 1][q - 1] + matrix[p - 1][q - 1];
                        int t = k - sum[p][q];
                        if (t == 0) {
                            return k;
                        } else if (t > 0) {
                            diff = Math.min(diff, t);
                        }
                    }
                }
            }
        }

        return k - diff;
    }

    public static int maxSumSubmatrix2(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][][][] sum = new int[m + 1][n + 1][m + 1][n + 1];
        int[] row = new int[m];
        int[] column = new int[n];

        int diff = Integer.MAX_VALUE;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                Arrays.fill(row, 0);
                Arrays.fill(column, 0);
                for (int p = i + 1; p < m; p++) {
                    row[p] = row[p - 1] + matrix[p][j];
                }
                for (int q = j + 1; q < n; q++) {
                    column[q] = column[q - 1] + matrix[i][q];
                }

                for (int p = i; p < m; p++) {
                    for (int q = j; q < n; q++) {
                        sum[i][j][p][q] = sum[i + 1][j + 1][p][q] + row[p] + column[q] + matrix[i][j];
                        int t = k - sum[i][j][p][q];
                        if (t == 0) {
                            return k;
                        } else if (t > 0) {
                            diff = Math.min(diff, t);
                        }
                    }
                }
            }
        }

        return k - diff;
    }
}
