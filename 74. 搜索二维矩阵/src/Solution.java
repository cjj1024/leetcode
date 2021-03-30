/**
 * @author cuijunjie
 * @create 2020--14-11:28
 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        System.err.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix(matrix, 20));
        System.out.println(searchMatrix(matrix, 23));
        System.out.println(searchMatrix(matrix, -1));
        System.out.println(searchMatrix(new int[][]{{1}}, 1));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            mid = (left + right) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][0] < target) {
                if (matrix[mid][matrix[0].length - 1] >= target) {
                    break;
                } else {
                    left = mid + 1;
                }
            } else {
                break;
            }
        }

        int x = (left + right) / 2;

        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (matrix[x][mid] > target) {
                right = mid - 1;
            } else if (matrix[x][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                return false;
            }
            if (matrix[i][matrix[0].length - 1] < target) {
            } else {
                return BinarySearch(matrix[i], target);
            }
        }

        return false;
    }

    public static boolean BinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
