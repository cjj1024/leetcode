/**
 * @author cuijunjie
 * @create 2020--18-14:59
 */
public class Solution {
    public static void main(String[] args) {
        String s1 = "abc", s2 = "bca";
        System.out.println(isScramble(s1, s2));
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) &&
            isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }

        return false;
    }

//    public static boolean isScramble(String s1, String s2) {
//        if (s1 == null && s2 == null) {
//            return true;
//        }
//        if (s1 == null && s2 != null || s1 != null && s2 == null) {
//            return false;
//        }
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//
//        char[] sChar1 = s1.toCharArray();
//        char[] sChar2 = s2.toCharArray();
//        int n = sChar1.length;;
//        boolean[][][] dp = new boolean[n][n][n + 1];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                dp[i][j][1] = sChar1[i] == sChar2[j];
//            }
//        }
//        for (int k = 2; k <= n; k++) {
//            for (int i = 0; i <= n - k; i++) {
//                for (int j = 0; j <= n - k; j++) {
//                    for (int w = 1; w < k; w++) {
//                        if (dp[i][j][w] && dp[i + w][j + w][k - w]) {
//                            dp[i][j][k] = true;
//                            break;
//                        }
//                        if (dp[i][j + k - w][w] && dp[i + w][j][k - w]) {
//                            dp[i][j][k] = true;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//        return dp[0][0][n];
//    }
}
