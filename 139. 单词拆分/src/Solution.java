import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-09-16-10:14
 */
public class Solution {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hashSet = new HashSet<>(wordDict);

        int maxLen = 0;
        for (String s1 : wordDict) {
            maxLen = Math.max(maxLen, s1.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && hashSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
                if (i - j > maxLen) {
                    break;
                }
            }
        }

        return dp[s.length()];
    }

//    public static boolean wordBreak(String s, List<String> wordDict) {
//        return backtrace(s, wordDict, new StringBuilder(s.length()));
//    }
//
//    public static boolean backtrace(String s, List<String> wordDict, StringBuilder sb) {
//        if (sb.length() > s.length()) {
//            return false;
//        }
//        if (s.length() == sb.length() && s.equals(sb.toString())) {
//            return true;
//        }
//        for (String word : wordDict) {
//            sb.append(word);
//            if (backtrace(s, wordDict, sb)) {
//                return true;
//            }
//            sb.delete(sb.length() - word.length(), sb.length());
//        }
//
//        return false;
//    }
}
