import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author CuiJunJie
 * @create 2020-09-29-10:20
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{1, 2, 3, 4, 5}));
        System.out.println(largestNumber(new int[]{20, 9}));
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(largestNumber(new int[]{432, 43243}));
        System.out.println(largestNumber(new int[]{3,43,48,94,85,33,64,32,63,66}));
    }

    private static int compareIntByString(String s1, String s2) {
        if (s1.length() == 0) {
            return -1;
        } else if (s2.length() == 0) {
            return 1;
        }
        if (s1.length() > s2.length()) {
            if (s1.substring(0, s2.length()).compareTo(s2) == 0) {
                return compareIntByString(s1.substring(s2.length()), s2);
            } else {
                return -s1.substring(0, s2.length()).compareTo(s2);
            }
        } else {
            if (s2.substring(0, s1.length()).compareTo(s1) == 0) {
                return compareIntByString(s1, s2.substring(s1.length()));
            } else {
                return s2.substring(0, s1.length()).compareTo(s1);
            }
        }
    }

    public static String largestNumber(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            if (s1.length() == s2.length()) {
                return -s1.compareTo(s2);
            } else {
                return compareIntByString(s1, s2);
            }
        });

        for (int num : nums) {
            queue.offer(num);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(String.valueOf(queue.poll()));
        }

        String s = sb.toString();
        if (s.charAt(0) == '0') {
            return "0";
        }

        return s;
    }

//    public static String largestNumber(int[] nums) {
//        if (nums == null || nums.length < 1) {
//            return "";
//        }
//
//        String[] numStrs = new String[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            numStrs[i] = String.valueOf(nums[i]);
//        }
//
//        Arrays.sort(numStrs, (s1, s2) -> -(s1 + s2).compareTo(s2 + s1));
//
//        if ("0".equals(numStrs[0])) {
//            return "0";
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (String str : numStrs) {
//            sb.append(str);
//        }
//
//        return sb.toString();
//    }
}
