import java.util.Stack;

import static java.lang.Integer.max;

/**
 * @author cuijunjie
 * @create 2020--27-18:11
 */
public class Solution {
    public static void main(String[] args) {
        String s = "aba";

        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {

        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        char[] charArray = s.toCharArray();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        for (int i = 0; i < charArray.length; i++) {
            int len1 = expandAroundCenter(charArray, i, i);
            int len2 = expandAroundCenter(charArray, i, i + 1);
            int len = max(len1, len2);
            if (len > maxLen) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
                maxLen = len;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(char[] charArray, int left, int right) {

        int L = left, R = right;
        while (L >= 0 && R < charArray.length && charArray[L] == charArray[R]) {
            --L;
            ++R;
        }

        return R - L - 1;

    }

//    // 动态规划
//    public static String longestPalindrome(String s) {
//
//        if (s.length() == 0 || s.length() == 1) {
//            return s;
//        }
//
//        int n = s.length();
//        boolean[][] dp = new boolean[n][n];
//
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = true;
//        }
//
//        char[] charArray = s.toCharArray();
//        int begin = 0;
//        int maxLen = 1;
//        int len = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = i + 1; j < n; j++) {
//                if (charArray[i] == charArray[j]) {
//                    if (j - i < 3) {
//                        dp[i][j] = true;
//                    } else {
//                        dp[i][j] = dp[i + 1][j - 1];
//                    }
//                } else {
//                    dp[i][j] = false;
//                }
//
//                if (dp[i][j] && (len = j - i + 1) > maxLen) {
//                    begin = i;
//                    maxLen = len;
//                }
//            }
//        }
//
//        return s.substring(begin, begin + maxLen);
//    }

//    // 暴力搜索
//    public static String longestPalindrome(String s) {
//
//        if (s.length() == 0) {
//            return "";
//        }
//        if (s.length() == 1) {
//            return s;
//        }
//
//        int maxNum = 0;
//        String ret = "";
//        StringBuffer tmp = new StringBuffer(1000);
//
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == s.charAt(i - 1)) {
//                tmp.append(s.charAt(i));
//                tmp.append(s.charAt(i - 1));
//                int j = i + 1;
//                int k = 3;
//                while (j < s.length() && k <= j && s.charAt(j) == s.charAt(j - k)) {
//                    tmp.append(s.charAt(j));
//                    tmp.append(s.charAt(j - k));
//                    j++;
//                    k += 2;
//                }
//                if (k > maxNum) {
//                    maxNum = k;
//                    ret = tmp.toString();
//                }
//                tmp.setLength(0);
//            }
//            if (i - 2 >= 0 && s.charAt(i) == s.charAt(i - 2)) {
//                tmp.append(s.charAt(i - 1));
//                tmp.append(s.charAt(i));
//                tmp.append(s.charAt(i - 2));
//                int j = i + 1;
//                int k = 4;
//                while (j < s.length() && k <= j && s.charAt(j) == s.charAt(j - k)) {
//                    tmp.append(s.charAt(j));
//                    tmp.append(s.charAt(j - k));
//                    j++;
//                    k += 2;
//                }
//                if (k > maxNum) {
//                    maxNum = k;
//                    ret = tmp.toString();
//                }
//                tmp.setLength(0);
//            }
//        }
//
//        StringBuffer ret2 = new StringBuffer(ret.length());
//        for (int i = ret.length() - 1; i >= 0; i -= 2) {
//            ret2.append(ret.charAt(i));
//        }
//        for (int i = 1; i < ret.length(); i += 2) {
//            ret2.append(ret.charAt(i));
//        }
//
//        if (ret.length() == 0) {
//            ret2.append(s.charAt(0));
//        }
//
//        return ret2.toString();
//    }
}
