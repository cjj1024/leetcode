import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--10-11:20
 */
public class Solution {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list : lists) {
            for (String str : list) {
                System.out.println(str);
            }
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        int[] count = new int[26];
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder(26 * 2);
            for (int i : count) {
                sb.append('#');
                sb.append(i);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        ArrayList<List<String>> ret = new ArrayList<>();
        for (String key : map.keySet()) {
            ret.add(map.get(key));
        }

        return ret;
    }

//    public static List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> ret = new ArrayList<>();
//
//        HashMap<String, List<String>> map = new HashMap<>();
//        for (String str : strs) {
//            char[] charArray = str.toCharArray();
//            Arrays.sort(charArray);
//            String key = new String(charArray);
//            if (!map.containsKey(key)) {
//                map.put(key, new ArrayList<>());
//            }
//            map.get(key).add(str);
//        }
//
//        for (String key : map.keySet()) {
//            ret.add(map.get(key));
//        }
//
//        return ret;
//    }

//    public static List<List<String>> groupAnagrams(String[] strs) {
//        if (strs.length < 1) {
//            return null;
//        }
//
//        List<List<String>> ret = new ArrayList<>();
//        String[] strs2 = new String[strs.length];
//        for (int i = 0; i < strs.length; i++) {
//            char[] charArray = strs[i].toCharArray();
//            Arrays.sort(charArray);
//            strs2[i] = new String(charArray);
//        }
//
//        List<String> list = new ArrayList<>();
//        String tmp = "";
//        boolean[] used = new boolean[strs.length];
//        for (int j = 0; j < strs.length; j++) {
//            for (int i = 0; i < strs.length; i++) {
//                if (used[i]) {
//                    continue;
//                }
//                if (list.size() == 0) {
//                    list.add(strs[i]);
//                    used[i] = true;
//                    tmp = strs2[i];
//                } else if (tmp.equals(strs2[i])) {
//                    list.add(strs[i]);
//                    used[i] = true;
//                }
//            }
//            if (list.size() > 0) {
//                ret.add(list);
//                list = new ArrayList<>();
//            }
//        }
//
//        return ret;
//    }
}
