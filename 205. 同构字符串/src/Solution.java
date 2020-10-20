import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2020-10-20-11:00
 */
public class Solution {
    public static void main(String[] args) {
        String s = "ab", t = "aa";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c1 = s.charAt(i);
            Character c2 = t.charAt(i);
            Character c = map1.getOrDefault(c1, c2);
            map1.put(c1, c);
            if (c != c2) {
                return false;
            }
            c = map2.getOrDefault(c2, c1);
            map2.put(c2, c);
            if (c != c1) {
                return false;
            }
        }

        return true;
    }
}
