

/**
 * @author CuiJunJie
 * @create 2020/9/19 22:31
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {10, 11, 12};
        System.out.println(sumOddLengthSubarrays(arr));
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        if (arr == null) {
            return 0;
        }

        int step = 1;
        int sum = 0;
        while (step <= arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if (i + step > arr.length) {
                    continue;
                }
                for (int k = 0; k < step; k++) {
                    sum += arr[i + k];
                }
            }
            step += 2;
        }

        return sum;
    }
}
