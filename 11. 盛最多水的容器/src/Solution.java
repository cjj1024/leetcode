/**
 * @author cuijunjie
 * @create 2020--01-16:18
 */
public class Solution {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ret = 0;
        while (left < right) {
            ret = Math.max(Math.min(height[left], height[right]) * (right - left), ret);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return ret;
    }

//    public static int maxArea(int[] height) {
//        int ret = 0;
//        int area = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                if (ret < (area = Math.min(height[i], height[j]) * (j - i))) {
//                    ret = area;
//                }
//            }
//        }
//
//        return ret;
//    }
}
