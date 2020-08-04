import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--04-11:17
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    static List<String> ret = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backtrace(n, sb, 0);

        return ret;
    }

    public static void backtrace(int n, StringBuilder sb, int left) {
        if (n == 0 && left == 0) {
            ret.add(sb.toString());
            return;
        }
        if (n > 0) {
            sb.append('(');
            backtrace(n - 1, sb, left + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left > 0) {
            sb.append(')');
            backtrace(n, sb, left - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
