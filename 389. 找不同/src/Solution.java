/**
 * @author CuiJunJie
 * @create 2020/12/18-9:38
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
        System.out.println(findTheDifference("", "y"));
        System.out.println(findTheDifference("a", "aa"));
    }

    public static char findTheDifference(String s, String t) {
        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] != 0) {
                return (char) (i + 'a');
            }
        }

        return ' ';
    }
}
