/**
 * @author cuijunjie
 * @create 2020--04-16:48
 */
public class Solution {
    public static void main(String[] args) {
        String haystack = "baaa";
        String needle = "aaa";

        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }

        int idx = -1;
        char[] s1 = haystack.toCharArray();
        char[] s2 = needle.toCharArray();
        for (int i = 0; i <= s1.length - s2.length; i++) {
            if (s2[0] == s1[i]) {
                int k = i + 1;
                idx = i;
                int j = 1;
                for (; j < s2.length && k < s1.length; j++, k++) {
                    if (s1[k] != s2[j]) {
                        break;
                    }
                }
                if (j < s2.length) {
                    idx = -1;
                }
            }
            if (idx != -1) {
                break;
            }
        }

        return idx;
    }
}
