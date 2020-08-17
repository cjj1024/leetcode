import java.util.Stack;

/**
 * @author cuijunjie
 * @create 2020--17-15:38
 */
public class Solution {
    public static void main(String[] args) {
        int[] heights = {0, 9};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        int[] right = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] * (right[i] - left[i] - 1) > maxArea) {
                maxArea = heights[i] * (right[i] - left[i] - 1);
            }
        }

        return maxArea;
    }
}
