/**
 * @author cuijunjie
 * @create 2020--11-16:45
 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(4);
        for (int[] row : matrix) {
            for (int x : row) {
                System.out.print(x);
                System.out.print(" ");
            }
            System.out.println();
        }
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
