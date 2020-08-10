/**
 * @author cuijunjie
 * @create 2020--10-10:52
 */
public class Solution {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int[][] matrix = {  { 5, 1, 9,11},
                { 2, 4, 8,10},
        {13, 3, 6, 7},
    {15,14,12,16}};

        rotate(matrix);

        for (int[] row : matrix) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = tmp;
            }
        }
    }

//        [7,4,1],
//        [8,5,2],
//        [9,6,3]
//    public static void rotate(int[][] matrix) {
//        if (matrix.length == 0) {
//            return;
//        }
//        int len = matrix.length - 1;
//        int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                rotatedMatrix[j][len - i] = matrix[i][j];
//            }
//        }
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                matrix[i][j] = rotatedMatrix[i][j];
//            }
//        }
//    }
}
