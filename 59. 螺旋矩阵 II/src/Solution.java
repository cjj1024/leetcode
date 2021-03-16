/**
 * @author cuijunjie
 * @create 2020--11-16:45
 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix2(4);
        for (int[] row : matrix) {
            for (int x : row) {
                System.out.print(x);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix2(int n) {
        int[][] matrix = new int[n][n];
        int i = 0;
        int j = 0;
        int t = 0;
        int k = 1;
        while (k <= n * n) {
            if (n % 2 == 1 && t == n / 2) {
                matrix[t][t] = k++;
                break;
            }
            i = t;
            for (j = t; j < n - t - 1; j++) {
                matrix[i][j] = k++;
            }
            for (i = t; i < n - t - 1; i++) {
                matrix[i][j] = k++;
            }
            for (j = n - t - 1; j > t; j--) {
                matrix[i][j] = k++;
            }
            for (i = n - t - 1; i > t; i--) {
                matrix[i][j] = k++;
            }
            t++;
        }

        return matrix;
    }

    public static int[][] generateMatrix(int n) {
        if (n < 1) {
            return null;
        }
        int[][] matrix = new int[n][n];

        int left = 0;
        int up = 0;
        int right = n - 1;
        int down = n - 1;

        int num = 1;
        while (num <= n * n) {
            for (int i = left; i <= right; i++) {
                matrix[up][i] = num++;
            }
            up++;
            for (int i = up; i <= down; i++) {
                matrix[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[down][i] = num++;
            }
            down--;
            for (int i = down; i >= up; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }

        return matrix;
    }

//    public static int[][] generateMatrix(int n) {
//        if (n < 1) {
//            return null;
//        }
//        int[][] matrix = new int[n][n];
//
//        setRound(matrix, 0, 0, n - 1, n - 1, 1);
//
//        return matrix;
//    }

    static int setRound(int[][] matrix, int leftX, int leftY, int rightX, int rightY, int num) {
        if (leftX > rightX || leftY > rightX) {
            return num;
        }
        if (leftX == rightX) {
            for (int i = leftY; i <= rightY; i++) {
                matrix[leftX][i] = num++;
            }
            return num;
        }
        if (leftY == rightY) {
            for (int i = leftX; i <= rightX; i++) {
                matrix[i][leftY] = num++;
            }
            return num;
        }

        for (int i = leftY; i < rightY; i++) {
            matrix[leftX][i] = num++;
        }
        for (int i = leftX; i < rightX; i++) {
            matrix[i][rightY] = num++;
        }
        for (int i = rightY; i > leftY; i--) {
            matrix[rightX][i] = num++;
        }
        for (int i = rightX; i > leftX; i--) {
            matrix[i][leftY] = num++;
        }

        return setRound(matrix, leftX + 1, leftY + 1, rightX - 1, rightY - 1, num);
    }
}
