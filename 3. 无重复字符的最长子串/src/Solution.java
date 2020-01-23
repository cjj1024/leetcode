import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
            System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        int i, j = 0;
        int maxNum = 0;
        char c;
        for (i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (m.containsKey(c)) {
                j = Math.max(m.get(c), j - 1) + 1;
            }
            m.put(c, i);
            maxNum = Math.max(maxNum, i - j + 1);
        }
        return maxNum;
    }
}