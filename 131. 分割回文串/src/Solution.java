import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-09-10-9:41
 */
public class Solution {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> lists = partition(s);
        for (List<String> list : lists) {
            for (String s1 : list) {
                System.out.println(s1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        if (s == null || s.length() < 1) {
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();
        List<List<String>> ret = new ArrayList<>();
        backtrace(s, 0, list, ret);

        return ret;
    }

    private static void backtrace(String s, int start, List<String> list, List<List<String>> ret) {
        if (start == s.length()) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (!checkPalindrome(s, start, i)) {
                continue;
            }
            list.add(s.substring(start, i + 1));
            backtrace(s, i + 1, list, ret);
            list.remove(list.size() - 1);
        }
    }

    public static boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }

        return true;
    }
}
