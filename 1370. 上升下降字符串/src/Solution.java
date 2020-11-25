import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020/11/25-9:23
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc"));
        System.out.println(sortString("leetcode"));
        System.out.println(sortString("ggggggg"));
        System.out.println(sortString("spo"));
    }

    public static String sortString(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }

        char[] alphabet = new char[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer(s.length());
        int count = s.length();
        while (count > 0) {
            for (int j = 0; j < 26; j++) {
                if (alphabet[j] > 0) {
                    sb.append((char) (j + 'a'));
                    alphabet[j]--;
                    count--;
                }
            }
            for (int j = 25; j >= 0; j--) {
                if (alphabet[j] > 0) {
                    sb.append((char) (j + 'a'));
                    alphabet[j]--;
                    count--;
                }
            }
        }

        return sb.toString();
    }

//    public static String sortString(String s) {
//        if (s == null || s.length() < 1) {
//            return s;
//        }
//
//        Map<Character, Integer> map = new TreeMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            int count = map.getOrDefault(s.charAt(i), 0) + 1;
//            map.put(s.charAt(i), count);
//        }
//
//        int j;
//        int direction = 1;
//        StringBuffer sb = new StringBuffer(s);
//        int len = 0;
//        while (!map.isEmpty()) {
//            List<Character> keys = new ArrayList<>(map.keySet());
//            j = direction == 1 ? len : len + keys.size() - 1;
//            for (int i = 0; i < keys.size(); i++, j += direction) {
//                sb.setCharAt(j, keys.get(i));
//                int count = map.get(keys.get(i));
//                if (count == 1) {
//                    map.remove(keys.get(i));
//                } else {
//                    map.put(keys.get(i), count - 1);
//                }
//            }
//            direction = -direction;
//            len += keys.size();
//        }
//
//        return sb.toString();
//    }
}
