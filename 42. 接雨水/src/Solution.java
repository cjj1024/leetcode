import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @author cuijunjie
 * @create 2020--07-17:06
 */
public class Solution {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

//    public static int trap(int[] height) {
//        if (height.length == 0) {
//            return 0;
//        }
//
//        int volumn = 0;
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < height.length; i++) {
//            while (!stack.empty() && height[stack.peek()] < height[i]) {
//                int k = stack.pop();
//                if (stack.empty()) {
//                    break;
//                }
//                volumn += (Math.min(height[stack.peek()], height[i]) - height[k]) * (i - stack.peek() - 1);
//            }
//            stack.push(i);
//        }
//
//        return volumn;
//    }

    public static int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int volumn = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (maxLeft > height[left]) {
                    volumn += maxLeft - height[left];
                } else {
                    maxLeft = height[left];
                }
                left++;
            } else {
                if (maxRight > height[right]) {
                    volumn += maxRight - height[right];
                } else {
                    maxRight = height[right];
                }
                right--;
            }
        }

        return volumn;
    }

//    public static int trap(int[] height) {
//        if (height.length == 0) {
//            return 0;
//        }
//        int volumn = 0;
//        int[] maxLeft = new int[height.length];
//        int[] maxRight = new int[height.length];
//        maxLeft[0] = height[0];
//        for (int i = 1; i < height.length; i++) {
//            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
//        }
//        maxRight[height.length - 1] = height[height.length - 1];
//        for (int i = height.length - 2; i >= 0; --i) {
//            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
//        }
//        for (int i = 0; i < height.length; i++) {
//            volumn += Math.min(maxLeft[i], maxRight[i]) - height[i];
//        }
//
//        return volumn;
//    }

//    public static int trap(int[] height) {
//        int volumn = 0;
//        for (int i = 0; i < height.length; i++) {
//            int maxLeft = 0;
//            int maxRight = 0;
//            for (int j = i; j >= 0; j--) {
//                if (height[j] > maxLeft) {
//                    maxLeft = height[j];
//                }
//            }
//            for (int j = i; j < height.length; j++) {
//                if (height[j] > maxRight) {
//                    maxRight = height[j];
//                }
//            }
//            volumn += Math.min(maxLeft, maxRight) - height[i];
//        }
//
//        return volumn;
//    }

//    public static int trap(int[] height) {
//        if (height.length == 0) {
//            return 0;
//        }
//        int volumn = 0;
//        int maxHeight = Arrays.stream(height).max().getAsInt();
//
//        for (int i = 0; i < maxHeight; i++) {
//            int j = 0;
//            while (j < height.length - 1) {
//                while (j < height.length - 1 && height[j] < 1) {
//                    ++j;
//                }
//                int k = j + 1;
//                while (k < height.length && height[k] < 1) {
//                    k++;
//                }
//                if (k == j + 1) {
//                    j = k;
//                    continue;
//                }
//                if (k == height.length) {
//                    break;
//                }
//                int a = k - j - 1;
//                int b = Math.min(height[j], height[k]);
//                if (a > 0 && b > 0) {
//                    volumn += a;
//                    j = k;
//                }
//
//            }
//            for (j = 0; j < height.length; j++) {
//                height[j] -= 1;
//            }
//        }
//
//        return volumn;
//    }
}
