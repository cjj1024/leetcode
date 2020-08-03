import java.util.Arrays;
import java.util.Collections;

/**
 * @author cuijunjie
 * @create 2020--03-10:26
 */
public class Solution {
    public static void main(String[] args) {
        String[] strs = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLen) {
                minLen = str.length();
            }
        }

        StringBuilder ret = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < minLen; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    flag = false;
                }
            }
            if (flag) {
                ret.append(strs[0].charAt(i));
            } else {
                break;
            }
        }

        return ret.toString();
    }
}
