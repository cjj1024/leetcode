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
        int[] num0 = new int[strs.length];
        int[] num1 = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    num0[i]++;
                } else {
                    num1[i]++;
                }
            }
        }

        int[] existNum0 = new int[strs.length];
        int[] existNum1 = new int[strs.length];
        int[] dp = new int[strs.length];


        for (int i = 0; i < strs.length; i++) {
            if (num0[i] <= m && num1[i] <= n) {
                existNum0[i] = num0[i];
                existNum1[i] = num1[i];
                dp[i] = 1;
            }
        }

        for (int i = 1; i < strs.length; i++) {
            int index = -1;
            int minValue = -1;
            for (int j = 0; j < i; j++) {
                if (existNum0[j] + num0[i] <= m && existNum1[j] + num1[i] <= n) {
                    if (dp[j] > minValue) {
                        index = j;
                        minValue = dp[j];
                    }
                }
            }
            if (index != -1) {
                existNum0[i] = existNum0[index] + num0[i];
                existNum1[i] = existNum1[index] + num1[i];
                dp[i] = dp[index] + 1;
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
