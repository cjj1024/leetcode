import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2021/7/3-10:01
 */
public class Solution {
    public static void main(String[] args) {
        Character[] c = new Character[200];
        for (int i = 0; i < 200; i++) {
            c[i] = 'a';
        }

        System.out.println(c[190] == c[2]);
    }
    public static String frequencySort(String s) {
        Character[] sChars = new Character[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            sChars[i++] = c;
        }

        Arrays.sort(sChars, (c1, c2) -> {
            if (map.get(c1).equals(map.get(c2))) {
                return (int) ((int) c1 - c2);
            } else {
                return map.get(c2) - map.get(c1);
            }
        });

        char[] t = new char[s.length()];
        for (i = 0; i < t.length; i++) {
            t[i] = sChars[i];
        }
        return String.valueOf(t);
    }
}
