import java.util.HashMap;
import java.util.Map;

/**
 * @author cuijunjie
 * @create 2020--15-10:44
 */
public class Solution {
    public static void main(String[] args) {
        String S = "a", T = "a";
        System.out.println(minWindow(S, T));
    }

    public static String minWindow(String s, String t) {
        if (s == null || s.length() < 1) {
            return s;
        }
        if (t == null || t.length() < 1) {
            return t;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, 0);
            count.put(c, 0);
        }
        for (char c : t.toCharArray()) {
            count.put(c, count.get(c) + 1);
        }

        char[] sChar = s.toCharArray();
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder(s.length());
        int minLen = Integer.MAX_VALUE;
        while (right < sChar.length) {
            if (map.containsKey(sChar[right])) {
                map.put(sChar[right], map.get(sChar[right]) + 1);
            }
            while (check(map, count)) {
                if (right - left + 1 < minLen) {
                    sb.setLength(0);
                    sb.append(sChar, left, right - left + 1);
                    minLen = sb.length();
                }
                if (map.containsKey(sChar[left])) {
                    map.put(sChar[left], Math.max(map.get(sChar[left]) - 1, 0));
                }
                left++;
            }
            right++;
        }

        return sb.toString();
    }

    public static boolean check(Map<Character, Integer> map, Map<Character, Integer> count) {
        for (Character key : map.keySet()) {
            if (map.get(key) < count.get(key)) {
                return false;
            }
        }
        return true;
    }
}
