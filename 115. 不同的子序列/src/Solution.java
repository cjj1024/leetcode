/**
 * @author CuiJunJie
 * @create 2020-08-31-10:25
 */
public class Solution {
    public static void main(String[] args) {
        String S = "rabbbit", T = "rabbit";
        System.out.println(numDistinct(S, T));
    }

    public static int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }

//    public static int numDistinct(String s, String t) {
//        if (s == null && t == null) {
//            return 1;
//        }
//        if (s == null || t == null) {
//            return 0;
//        }
//        if (s.length() < t.length()) {
//            return 0;
//        }
//
//        int[][] dp = new int[t.length() + 1][s.length() + 1];
//        for (int i = 0; i <= s.length(); i++) {
//            dp[0][i] = 1;
//        }
//        for (int i = 1; i < t.length(); i++) {
//            dp[i][0] = 0;
//        }
//
//        char[] sChar = s.toCharArray();
//        char[] tChar = t.toCharArray();
//        for (int j = 1; j <= sChar.length; j++) {
//            for (int i = 1; i <= tChar.length; i++) {
//                if (sChar[j - 1] == tChar[i - 1]) {
//                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
//                } else {
//                    dp[i][j] = dp[i][j - 1];
//                }
//            }
//        }
//
//        return dp[tChar.length][sChar.length];
//    }

//    public static int numDistinct(String s, String t) {
//        if (s == null && t == null) {
//            return 1;
//        }
//        if (s == null || t == null) {
//            return 0;
//        }
//        if (s.length() < t.length()) {
//            return 0;
//        }
//
//        return backtrace(s, t, 0, new StringBuilder(t.length()));
//    }

    public static int backtrace(String s, String t, int k, StringBuilder sb) {
        if (sb.length() > t.length()) {
            return 0;
        }
        if (t.equals(sb.toString())) {
            return 1;
        }

        int num = 0;
        for (int i = k; i < s.length(); i++) {
            sb.append(s.charAt(i));
            num += backtrace(s, t, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        return num;
    }
}
