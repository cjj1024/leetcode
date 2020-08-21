/**
 * @author CuiJunJie
 * @create 2020-08-21-14:36
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        if (n < 1) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }

        return dp[n];
    }

//    public static int numTrees(int n) {
//        if (n < 1) {
//            return 0;
//        }
//
//        return recursion(0, n - 1);
//    }
//
//    public static int recursion(int left, int right) {
//        if (left > right) {
//            return 1;
//        }
//
//        int num = 0;
//        for (int i = left; i <= right; i++) {
//            int leftNum = recursion(left, i - 1);
//            int rightNum = recursion(i + 1, right);
//            num += leftNum * rightNum;
//        }
//
//        return num;
//    }
}
