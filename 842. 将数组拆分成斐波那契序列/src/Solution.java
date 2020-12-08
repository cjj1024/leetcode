import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020/12/8-9:50
 */
public class Solution {
    public static void main(String[] args) {
        splitIntoFibonacci("123456579").forEach(System.out::println);
        splitIntoFibonacci("11235813").forEach(System.out::println);
        splitIntoFibonacci( "0123").forEach(System.out::println);
        splitIntoFibonacci("5511816597").forEach(System.out::println);
        splitIntoFibonacci("0000").forEach(System.out::println);
    }

    public static List<Integer> splitIntoFibonacci(String S) {
        if (S == null || S.length() < 1) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();

        if (S.charAt(0) == '0') {
            list.add(0);
            if (!helper(S, list, 1)) {
                return new ArrayList<>();
            }
        } else {
            helper(S, list, 0);
        }

        return list;
    }

    private static boolean helper(String s, List<Integer> list, int k) {
        if (list.size() < 2) {
            boolean flag = false;
            long cur = 0;
            for (int i = k; i < s.length(); i++) {
                cur = cur * 10 + s.charAt(i) - '0';
                if (cur > Integer.MAX_VALUE) {
                    break;
                }
                list.add((int) cur);
                flag = helper(s, list, i + 1);
                if (flag) {
                    break;
                } else {
                    list.remove(list.size() - 1);
                }
            }
            return flag;
        }

        long num1 = list.get(list.size() - 1);
        long num2 = list.get(list.size() - 2);
        long num = num1 + num2;
        if (num > Integer.MAX_VALUE) {
            return false;
        }
        String str = String.valueOf(num);
        if (k + str.length() > s.length()) {
            return false;
        }
        String tmp = s.substring(k, k + str.length());
        if (str.equals(tmp)) {
            list.add((int) num);
            if (k + str.length() == s.length()) {
                return true;
            }
            if (helper(s, list, k + str.length())) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }

        return false;
    }
}
