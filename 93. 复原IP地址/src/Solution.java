import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-08-20-14:54
 */
public class Solution {
    public static void main(String[] args) {
        String s = "101023";
        List<String> ips = restoreIpAddresses(s);
        for (String ip : ips) {
            System.out.println(ip);
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return ret;
        }

        recursion(s, 0, 0, new StringBuilder(12), ret);


        return ret;
    }

    public static void recursion(String s, int seg, int k, StringBuilder sb, List<String> ret) {
        if (seg == 4 && sb.length() == s.length() + 4) {
            ret.add(sb.substring(0, sb.length() - 1));
            return;
        }
        if (s.length() - k < (4 - seg) || s.length() - k > (12 - seg * 3)) {
            return;
        }

        for (int i = 1; i < 4 && i + k < s.length() + 1; i++) {
            if (i == 1 && s.charAt(k) == '0') {
                sb.append(s, k, k + i);
                sb.append('.');
                recursion(s, seg + 1, k + i, sb, ret);
                sb.delete(sb.length() - i - 1, sb.length());
                break;
            }
            if (i == 3 && Integer.parseInt(s.substring(k, k + i)) > 255) {
                continue;
            }
            sb.append(s, k, k + i);
            sb.append('.');
            recursion(s, seg + 1, k + i, sb, ret);
            sb.delete(sb.length() - i - 1, sb.length());
        }
    }
}
