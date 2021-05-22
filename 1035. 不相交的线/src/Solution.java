import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2021/5/21-9:31
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));  // 2
        System.out.println(maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));   // 3
        System.out.println(maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));    // 2
    }

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

//    private static int maxLen;
//    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
//        maxLen = 0;
//        backtrace(nums1, 0, nums2, 0, 0);
//        return maxLen;
//    }
//
//    private static void backtrace(int[] nums1, int k1, int[] nums2, int k2, int num) {
//        if (k1 == nums1.length || k2 == nums2.length) {
//            maxLen = Math.max(maxLen, num);
//            return;
//        }
//
//
//        backtrace(nums1, k1 + 1, nums2, k2, num);
//        for (int i = k2; i < nums2.length; i++) {
//            if (nums1[k1] == nums2[i]) {
//                backtrace(nums1, k1 + 1, nums2, i + 1, num + 1);
//                break;
//            }
//        }
//    }
}
