/**
 * @author CuiJunJie
 * @create 2020-11-06-16:23
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] rets = productExceptSelf(nums);
        for (int ret : rets) {
            System.out.println(ret);
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] products = new int[len];
        for (int i = 0; i < len; i++) {
            products[i] = left[i] * right[i];
        }

        return products;
    }
}
