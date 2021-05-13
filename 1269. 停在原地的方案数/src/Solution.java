import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2021/5/13-9:42
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(numWays(3, 2));  // 4
        System.out.println(numWays(2, 4));  // 2
        System.out.println(numWays(4, 2));  // 8
        System.out.println(numWays(27, 7)); // 127784505
    }

    private static int MODULUS = 1000000000 + 7;
    public static int numWays(int steps, int arrLen) {
        int maxColumn = Math.min(steps, arrLen);
        int[][] dp = new int[steps + 1][maxColumn + 2];

        dp[0][1] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 1; j <= maxColumn; j++) {
                long t = (long) dp[i - 1][j - 1] + dp[i - 1][j] + dp[i - 1][j + 1];
                t = t % MODULUS;
                dp[i][j] = (int) t;
            }
        }

        return dp[steps][1];
    }


//    public static int numWays(int steps, int arrLen) {
//        map = new HashMap<>();
//        long nums = backtrace(steps, arrLen, 0, 0);
//
//        return (int) nums;
//    }
//
//
//    private static Map<String, Long> map;
//    private static long backtrace(int steps, int arrLen, int k, int pos) {
//        String key = k + "#" + pos;
//        if (map.containsKey(key)) {
//            return map.get(key);
//        }
//        if (pos > steps - k) {
//            return 0;
//        }
//        if (pos < 0 || pos >= arrLen) {
//            return 0;
//        }
//
//        if (k == steps) {
//            if (pos == 0) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//
//        long num = 0;
//        num += backtrace(steps, arrLen, k + 1, pos - 1);
//        num += backtrace(steps, arrLen, k + 1, pos);
//        num += backtrace(steps, arrLen, k + 1, pos + 1);
//
//        num = num % (1000000000 + 7);
//
//        map.put(key, num);
//
//        return num;
//    }
}
