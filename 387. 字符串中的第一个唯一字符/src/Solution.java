/**
 * @author CuiJunJie
 * @create 2020/12/23-9:53
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
