/**
 * @author cuijunjie
 * @create 2020--19-14:12
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(numDecodings("17"));

        System.out.println(numDecodings("12")); // 2
        System.out.println(numDecodings("226")); // 3
        System.out.println(numDecodings("0")); // 0
        System.out.println(numDecodings("06")); // 0
        System.out.println(numDecodings("1001")); // 0
        System.out.println(numDecodings("10")); // 1
        System.out.println(numDecodings("2101")); // 1
        System.out.println(numDecodings("230")); // 0
    }

    public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        if (s.charAt(0) == '0') {
            return 0;
        }

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i - 1);
            char c2 = s.charAt(i);
            if (c2 == '0' && (c == '0' || c > '2')) {
                return 0;
            }
            if (c == '0') {
                dp[i + 1] = dp[i];
            } else if (c2 == '0') {
                dp[i + 1] = dp[i - 1];
            } else if (c == '1') {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else if (c == '2' && c2 >= '0' && c2 <= '6') {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else {
                dp[i + 1] = dp[i];
            }
        }

        return dp[s.length()];
    }

    public static int numDecodings2(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        char[] sChar = s.toCharArray();

        int pre = 1, cur = 1, tmp;
        if (sChar[0] == '0') {
            return 0;
        }
        for (int i = 1; i < sChar.length; i++) {
            tmp = cur;
            if (sChar[i] == '0') {
                if (sChar[i - 1] == '1' || sChar[i - 1] == '2') {
                    cur = pre;
                } else {
                    return 0;
                }
            } else if (sChar[i - 1] == '1' || (sChar[i - 1] == '2' && (sChar[i] >= '1' && sChar[i] <= '6'))){
                cur = cur + pre;
            }
            pre = tmp;
        }
        return cur;
    }
}
