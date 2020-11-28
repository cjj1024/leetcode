import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2020/11/28-16:51
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        if (pattern == null && s == null) {
            return true;
        }
        if (pattern == null || s == null) {
            return false;
        }

        String[] words = s.split(" ");
        int len1 = pattern.length();
        int len2 = words.length;
        if (len1 != len2) {
            return false;
        }

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            boolean flag1 = map1.containsKey(pattern.charAt(i));
            boolean flag2 = map2.containsKey(words[i]);
            if (!flag1 && !flag2) {
                map1.put(pattern.charAt(i), words[i]);
                map2.put(words[i], pattern.charAt(i));
            } else if (flag1 && flag2) {
                if (!map1.get(pattern.charAt(i)).equals(words[i]) || !map2.get(words[i]).equals(pattern.charAt(i))) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
