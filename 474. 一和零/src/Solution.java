import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2021/3/10-14:42
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(findMaxForm(new String[]{"001", "110","0000","0000"}, 9, 2));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp =  new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroNum = 0;
            int oneNum = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
