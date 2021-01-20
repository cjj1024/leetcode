import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @create CuiJunJie
 * @date 2021/1/20-20:24
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{1, 2, 3, 4})); //24
        System.out.println(maximumProduct(new int[]{-100,-98,-1,2,3,4})); // 39200
        System.out.println(maximumProduct(new int[]{-8,-7,-2,10,20})); // 1120
    }

    public static int maximumProduct(int[] nums) {
        int[] maxNum = new int[3];
        maxNum[0] = nums[0];
        maxNum[1] = nums[1];
        maxNum[2] = nums[2];
        Arrays.sort(maxNum);

        int[] minNum = new int[3];
        minNum[0] = nums[0];
        minNum[1] = nums[1];
        minNum[2] = nums[2];
        Arrays.sort(minNum);


        for (int i = 3; i < nums.length; i++) {
            if (nums[i] > maxNum[2]) {
                maxNum[0] = maxNum[1];
                maxNum[1] = maxNum[2];
                maxNum[2] = nums[i];
            } else if (nums[i] > maxNum[1]) {
                maxNum[0] = maxNum[1];
                maxNum[1] = nums[i];
            } else if (nums[i] > maxNum[0]) {
                maxNum[0] = nums[i];
            }

            if (nums[i] < minNum[0]) {
                minNum[2] = minNum[1];
                minNum[1] = minNum[0];
                minNum[0] = nums[i];
            } else if (nums[i] < minNum[1]) {
                minNum[2] = minNum[1];
                minNum[1] = nums[i];
            } else if (nums[i] < minNum[2]) {
                minNum[2] = nums[i];
            }
        }

        return Math.max(maxNum[0] * maxNum[1] * maxNum[2],
                maxNum[2] * minNum[0] * minNum[1]);
    }
}
