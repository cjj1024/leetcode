import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuijunjie
 * @create 2020--18-14:59
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isScramble("abcde", "caebd")); // false
        System.out.println(isScramble("great", "rgeat")); // true
        System.out.println(isScramble("abcdbdacbdac", "bdacabcdbdac")); // true
        System.out.println(isScramble("abcd", "badc")); // true
        System.out.println(isScramble("dbdac", "abcdd")); // false
        System.out.println(isScramble("ccababcaabcb", "bccbccaaabab")); // true
    }




//    public static boolean isScramble(String s1, String s2) {
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//        char[] cstr1 = s1.toCharArray();
//        char[] cstr2 = s2.toCharArray();
//        if (isEqual(Arrays.copyOfRange(cstr1, 0, cstr1.length), Arrays.copyOfRange(cstr2, 0, cstr2.length)) == 0) {
//            return false;
//        }
//
//        return helper(cstr1, cstr2, 0, cstr1.length - 1, 0, cstr2.length - 1);
//    }
//
//    public static int isEqual(char[] cstr1, char[] cstr2) {
//        int ret = 0;
//        if (String.valueOf(cstr1).equals(String.valueOf(cstr2))) {
//            ret += 1;
//        }
//
//        Arrays.sort(cstr1);
//        Arrays.sort(cstr2);
//        if (String.valueOf(cstr1).equals(String.valueOf(cstr2))) {
//            ret += 1;
//        }
//        return ret;
//    }
//
//    private static boolean helper(char[] cstr1, char[] cstr2, int start1, int end1, int start2, int end2) {
//        if (start1 > end1 || start2 > end2) {
//            return false;
//        }
//
//        if (start1 == end1) {
//            return cstr1[start1] == cstr2[start2];
//        }
//
//        for (int i = start1, j = start2; i < end1 && j < end2; i++, j++) {
//            int flag;
//            if ((flag = isEqual(Arrays.copyOfRange(cstr1, start1, i + 1),
//                    Arrays.copyOfRange(cstr2, start2, j + 1))) > 0) {
//                if (helper(cstr1, cstr2, start1, i, start2, j)
//                        && helper(cstr1, cstr2, i + 1, end1, j + 1, end2)) {
//                    return true;
//                }
//            }
//            if ((flag = isEqual(Arrays.copyOfRange(cstr1, start1, i + 1),
//                    Arrays.copyOfRange(cstr2, end2 - j + start2, end2 + 1))) > 0) {
//                if (helper(cstr1, cstr2, start1, i, end2 - j + start2, end2)
//                        && helper(cstr1, cstr2, i + 1, end1, start2, end2 - j + start2 - 1)) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }

//    public static boolean isScramble(String s1, String s2) {
//        if (s1 == null && s2 == null) {
//            return true;
//        }
//        if (s1 == null || s2 == null) {
//            return false;
//        }
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//
//        if (s1.equals(s2)) {
//            return true;
//        }
//
//        for (int i = 1; i < s1.length(); i++) {
//            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
//                    isScramble(s1.substring(i), s2.substring(i))) {
//                return true;
//            }
//            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) &&
//            isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] sChar1 = s1.toCharArray();
        char[] sChar2 = s2.toCharArray();
        int n = sChar1.length;;
        boolean[][][] dp = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = sChar1[i] == sChar2[j];
            }
        }
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    for (int w = 1; w < k; w++) {
                        if (dp[i][j][w] && dp[i + w][j + w][k - w]) {
                            dp[i][j][k] = true;
                            break;
                        }
                        if (dp[i][j + k - w][w] && dp[i + w][j][k - w]) {
                            dp[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][0][n];
    }
}
