/**
 * @author CuiJunJie
 * @create 2020-11-07-10:06
 */
public class Solution {
    public static void main(String[] args) {
//        int[][] matrix = {
//            {1,   4,  7, 11, 15},
//            {2,   5,  8, 12, 19},
//            {3,   6,  9, 16, 22},
//            {10, 13, 14, 17, 24},
//            {18, 21, 23, 26, 30}
//        };
//        int[][] matrix = {
//                {-5}
//        };
        int[][] matrix = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };

        System.out.println(searchMatrix(matrix, 19));
        System.out.println(searchMatrix(matrix, 20));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }

        return false;
    }
}
