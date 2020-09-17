import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020-09-16-10:57
 */
public class Solution {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        List<String> strings = wordBreak(s, wordDict);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        if (!isWordBreak(s, wordDict)) {
            return new ArrayList<>();
        }
        map = new HashMap<>();
        List<String> ret = new ArrayList<>();
        HashSet<String> wordSet = new HashSet<>(wordDict);
        backtrace(s, 0, wordSet, new StringBuilder(s.length()), new ArrayList<>(), ret);

        return ret;
    }

    private static Map<Integer, List<String>> map;
    private static void backtrace(String s, int k, HashSet<String> wordSet, StringBuilder sb, List<String> list, List<String> ret) {
        if (sb.length() > s.length()) {
            return;
        }
        if (sb.length() == s.length() && s.equals(sb.toString())) {
            ret.add(String.join(" ", list));
        }

        if (map.containsKey(k)) {
            for (String ss : map.get(k)) {
                list.add(ss);
                sb.append(ss);
                backtrace(s, k + ss.length(), wordSet, sb, list, ret);
                sb.delete(k, sb.length());
                list.remove(list.size() - 1);
            }
        } else {
            List<String> tmp = new ArrayList<>();
            for (int i = k; i < s.length(); i++) {
                String ss = s.substring(k, i + 1);
                if (wordSet.contains(ss)) {
                    tmp.add(ss);
                    list.add(ss);
                    sb.append(ss);
                    backtrace(s, i + 1, wordSet, sb, list, ret);
                    sb.delete(k, sb.length());
                    list.remove(list.size() - 1);
                }
            }
            map.put(k, tmp);
        }
    }

    public static boolean isWordBreak(String s, List<String> wordDict) {
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

//    public static List<String> wordBreak(String s, List<String> wordDict) {
//        List<String> ret = new ArrayList<>();
//        backtrace(s, wordDict, new StringBuilder(s.length()), new ArrayList<>(), ret);
//
//        return ret;
//    }
//
//    public static void backtrace(String s, List<String> wordDict, StringBuilder sb, List<String> list, List<String> ret) {
//        if (sb.length() > s.length()) {
//            return;
//        }
//        if (sb.length() == s.length() && s.equals(sb.toString())) {
//            ret.add(String.join(" ", list));
//        }
//
//        for (String word : wordDict) {
//            sb.append(word);
//            list.add(word);
//            backtrace(s, wordDict, sb, list, ret);
//            sb.delete(sb.length() - word.length(), sb.length());
//            list.remove(list.size() - 1);
//        }
//    }
}
