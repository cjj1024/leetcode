import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-11-11-10:39
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int maxSquareNum = (int) Math.sqrt(n) + 1;
        int[] squareNums =  new int[maxSquareNum];
        for (int i = 0; i < maxSquareNum; i++) {
            squareNums[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s < maxSquareNum; s++) {
                if (i < squareNums[s]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - squareNums[s]] + 1);
            }
        }

        return dp[n];
    }

//    public static int numSquares(int n) {
//        List<Integer> list = new ArrayList<>();
//        list.add(n);
//        backtrace(n, list, 0, 2);
//
//        return list.stream().min(Comparator.comparingInt(o -> o)).get();
//    }
//
//    private static void backtrace(int n, List<Integer> list, int num, int x) {
//        if (x * x > n) {
//            list.add(num + n);
//        }
//
//        for (int i = x; i * i <= n; i++) {
//            backtrace(n - i * i, list, num + 1, x);
//        }
//    }
}
