/**
 * @author CuiJunJie
 * @create 2020-11-09-15:10
 */
public class Solution {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        int[] num1 = new int[26];
        int[] num2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            num1[s.charAt(i) - 'a'] += 1;
            num2[t.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (num1[i] != num2[i]) {
                return false;
            }
        }

        return true;
    }
}
