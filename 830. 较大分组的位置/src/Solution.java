import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2021/1/5-9:53
 */
public class Solution {
    public static void main(String[] args) {
//        largeGroupPositions("abcdddeeeeaabbbcd").forEach(System.out::println);
        largeGroupPositions("aaa").forEach(System.out::println);
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        if (s == null || s.length() < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();
        char c = s.charAt(0);
        int len = 1;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                len++;
            } else {
                if (len >= 3) {
                    list.add(Arrays.asList(start, start + len - 1));
                }
                c = s.charAt(i);
                start = i;
                len = 1;
            }
        }
        if (len >= 3) {
            list.add(Arrays.asList(start, start + len - 1));
        }

        return list;
    }
}
