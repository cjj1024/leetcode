/**
 * @author cuijunjie
 * @create 2020--14-11:14
 */
public class Solution {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}
//        };
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(matrix);

        for (int[] row : matrix) {
            for (int x : row) {
                System.out.printf("%d ", x);
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return;
        }

        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
