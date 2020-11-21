import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-11-19-11:10
 */
public class Solution {
    public static void main(String[] args) {
        List<String> ops = addOperators("123", 6);
        for (String op : ops) {
            System.out.println(op);
        }
        System.out.println("********************************");
        ops = addOperators("232", 8);
        for (String op : ops) {
            System.out.println(op);
        }
        System.out.println("********************************");
        ops = addOperators("105", 5);
        for (String op : ops) {
            System.out.println(op);
        }
        System.out.println("********************************");
        ops = addOperators("00", 0);
        for (String op : ops) {
            System.out.println(op);
        }
        System.out.println("********************************");
        ops = addOperators("3456237490", 9191);
        for (String op : ops) {
            System.out.println(op);
        }
        System.out.println("********************************");
        ops = addOperators("123456789", 45);
        for (String op : ops) {
            System.out.println(op);
        }

    }

    public static List<String> addOperators(String num, int target) {
        if (num == null || num.length() < 1) {
            return new ArrayList<>();
        }
        List<String> ops = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(num, target,0, ops, sb, 0, 0);

        return ops;
    }


    public static void helper(String num, int target, int k, List<String> ops, StringBuilder sb, long imd, long pre) {
        if (k == num.length()) {
            if (target == imd) {
                ops.add(sb.toString());
            }
        }

        for (int i = k + 1; i <= num.length(); i++) {
            String s = num.substring(k, i);
            long x = Long.parseLong(num.substring(k, i));
            if (String.valueOf(x).length() != s.length()) {
                continue;
            }
            if (sb.length() == 0) {
                sb.append(s);
                helper(num, target, i, ops, sb, imd + x, x);
                sb.delete(sb.length() - i + k, sb.length());
            } else {
                sb.append("+");
                sb.append(s);
                helper(num, target, i, ops, sb, imd + x, x);
                sb.delete(sb.length() - i + k - 1, sb.length());

                sb.append("-");
                sb.append(s);
                helper(num, target, i, ops, sb, imd - x, -x);
                sb.delete(sb.length() - i + k - 1, sb.length());

                sb.append("*");
                sb.append(s);
                helper(num, target, i, ops, sb, imd + x * pre - pre, x * pre);
                sb.delete(sb.length() - i + k - 1, sb.length());
            }
        }
    }
}
