import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author CuiJunJie
 * @create 2021/6/19-9:29
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxLength(Arrays.asList("un","iq","ue")));   // 4
        System.out.println(maxLength(Arrays.asList("cha","r","act","ers")));    // 6
        System.out.println(maxLength(Arrays.asList("yy","bkhwmpbiisbldzknpm")));   // 0
    }

    private static int maxLen = 0;
    public static int maxLength(List<String> arr) {
        List<Integer> masks = arr.stream().map(s -> {
            int mask = 0;
            int ch = 0;
            for (char c : s.toCharArray()) {
                ch = c - 'a';
                if (((mask >> ch) & 1) == 1) {
                    return 0;
                }
                mask |= (1 << ch);
            }
            return mask;
        }).filter(mask -> {
            return mask > 0;
        }).collect(Collectors.toList());

        maxLen = 0;

        backtrace(masks, 0, 0);

        return maxLen;
    }

    private static void backtrace(List<Integer> masks, Integer mask, int k) {
        if (k == masks.size()) {
            maxLen = Math.max(maxLen, Integer.bitCount(mask));
            return;
        }

        if ((mask & masks.get(k)) == 0) {
            backtrace(masks, mask | masks.get(k), k + 1);
        }
        backtrace(masks, mask, k + 1);
    }

//    private static Set<Character> set;
//    private static int maxLen = 0;
//    public static int maxLength(List<String> arr) {
//        List<String> newArr = arr.stream().filter(s -> {
//            set = new HashSet<>();
//            for (char c : s.toCharArray()) {
//                if (set.contains(c)) {
//                    return false;
//                }
//                set.add(c);
//            }
//            return true;
//        }).collect(Collectors.toList());
//
//        set = new HashSet<>();
//        maxLen = 0;
//
//        backtrace(newArr, 0);
//
//        return maxLen;
//    }
//
//    private static void backtrace(List<String> arr, int k) {
//        if (k == arr.size()) {
//            maxLen = Math.max(maxLen, set.size());
//            return;
//        }
//
//        if (!isContain(arr.get(k))) {
//            addToS(arr.get(k));
//            backtrace(arr, k + 1);
//            removeFromS(arr.get(k));
//        }
//
//        backtrace(arr, k + 1);
//    }
//
//    private static void removeFromS(String s) {
//        for (char c : s.toCharArray()) {
//            set.remove(c);
//        }
//    }
//
//    private static void addToS(String s) {
//        for (char c : s.toCharArray()) {
//            set.add(c);
//        }
//    }
//
//    private static boolean isContain(String s) {
//        for (char c : s.toCharArray()) {
//            if (set.contains(c)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
}
