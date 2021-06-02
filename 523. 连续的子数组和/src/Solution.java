import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2021/6/2-9:29
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(checkSubarraySum(new int[]{23,2,4,6,7}, 6));
//        System.out.println(checkSubarraySum(new int[]{23,2,6,4,7}, 6));
//        System.out.println(checkSubarraySum(new int[]{23,2,6,4,7}, 13));
//        System.out.println(checkSubarraySum(new int[]{23,2,4,6,6}, 7));     // true
//        System.out.println(checkSubarraySum(new int[]{5, 0, 0, 0}, 3));     // true
        System.out.println(checkSubarraySum(new int[]{0,1,0,3,0,4,0,4,0}, 5));      // false
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }

        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= n; i++) {
            int remainder = sum[i] % k;
            if (map.containsKey(remainder)) {
                int preIndex = map.get(remainder);
                if (i - preIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }

        return false;
    }

//    public static boolean checkSubarraySum(int[] nums, int k) {
//        int n = nums.length;
//        if (n < 2) {
//            return false;
//        }
//
//        int[] sum = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            sum[i] = sum[i - 1] + nums[i - 1];
//        }
//
//        for (int i = 0; i <= n; i++) {
//            for (int j = i + 2; j <= n; j++) {
//                if (((sum[j] - sum[i]) % k) == 0) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }

//    public static boolean checkSubarraySum(int[] nums, int k) {
//        int n = nums.length;
//        if (n < 2) {
//            return false;
//        }
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i++) {
//            dp[i] = nums[i];
//            for (int j = i + 1; j < n; j++) {
//                dp[j] = dp[j - 1] + nums[j];
//                if (dp[j] % k == 0) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
}
