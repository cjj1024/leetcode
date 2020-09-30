import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020-09-29-16:12
 */
public class Solution {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) {
            return new ArrayList<>();
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums[i] = map.get(s.charAt(i));
        }

        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> ret = new HashSet<>();

        int h = 0;
        int al = (int) Math.pow(4, 10);
        for (int i = 0; i < 10; i++) {
            h = h * 4 + nums[i];
        }
        seen.add(h);

        for (int i = 10; i < s.length(); i++) {
            h = h * 4 - al * nums[i - 10] + nums[i];
            if (seen.contains(h)) {
                ret.add(s.substring(i - 9, i + 1));
            }
            seen.add(h);
        }


        return new ArrayList<>(ret);
    }

//    public static List<String> findRepeatedDnaSequences(String s) {
//        if (s == null || s.length() < 10) {
//            return new ArrayList<>();
//        }
//
//        Set<String> set = new HashSet<>();
//        Set<String> seen = new HashSet<>();
//        for (int i = 0; i < s.length() - 9; i++) {
//            String sub = s.substring(i, i + 10);
//            if (seen.contains(sub)) {
//                set.add(sub);
//            }
//            seen.add(sub);
//        }
//
//        return new ArrayList<>(set);
//    }
}
