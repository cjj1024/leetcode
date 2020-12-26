import java.util.Stack;

/**
 * @author cuijunjie
 * @create 2020--17-17:27
 */
public class Solution {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '1', '1'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '1'},
                {'1', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '1'}
        };

        System.out.println(maximalRectangle(matrix));

    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] heights = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                heights[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0;j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[i][j] = heights[i - 1][j] + 1;
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int width = 0;
                int height = Integer.MAX_VALUE;
                for (int k = j; k < n; k++) {
                    if (heights[i][k] == 0) {
                        break;
                    } else {
                        width++;
                        height = Math.min(heights[i][k], height);
                        maxArea = Math.max(maxArea, width * height);
                    }
                }
            }
        }

        return maxArea;
    }

//    public static int maximalRectangle(char[][] matrix) {
//        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
//            return 0;
//        }
//
//        int[] left = new int[matrix[0].length];
//        int[] right = new int[matrix[0].length];
//        Stack<Integer> stack = new Stack<>();
//        int[] heights = new int[matrix[0].length];
//        int maxArea = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == '1') {
//                    heights[j] += 1;
//                } else {
//                    heights[j] = 0;
//                }
//            }
//            stack.clear();
//            for (int j = 0; j < matrix[0].length; j++) {
//                while (!stack.isEmpty() && heights[stack.peek()] >= heights[j]) {
//                    stack.pop();
//                }
//                left[j] = stack.isEmpty() ? -1 : stack.peek();
//                stack.push(j);
//            }
//            stack.clear();
//            for (int j = matrix[0].length - 1; j >= 0; j--) {
//                while (!stack.isEmpty() && heights[stack.peek()] >= heights[j]) {
//                    stack.pop();
//                }
//                right[j] = stack.isEmpty() ? heights.length : stack.peek();
//                stack.push(j);
//            }
//            for (int j = 0; j < matrix[0].length; j++) {
//                maxArea = Math.max(maxArea, heights[j] * (right[j] - left[j] - 1));
//            }
//        }
//
//        return maxArea;
//    }

//    public static int maximalRectangle(char[][] matrix) {
//        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
//            return 0;
//        }
//
//        int[][] dp = new int[matrix.length][matrix[0].length];
//        int maxArea = 0;
//        int width = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == '1') {
//                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
//                    width = dp[i][j];
//                    for (int k = i; k >= 0; k--) {
//                        width = Math.min(width, dp[k][j]);
//                        maxArea = Math.max(maxArea, width * (i - k + 1));
//                    }
//                }
//            }
//        }
//
//        return maxArea;
//    }
}
