import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2020-09-25-15:45
 */
public class Solution {
    public static void main(String[] args) {
        int  numerator = -1, denominator = -2147483648;
        System.out.println(fractionToDecimal(numerator, denominator));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            if (numerator > 0) {
                return "inf";
            } else if (numerator < 0) {
                return "-inf";
            } else {
                return "nan";
            }
        }

        StringBuilder ret = new StringBuilder();
        if (numerator > 0 ^ denominator > 0) {
            ret.append("-");
        }

        long a = Math.abs((long) numerator);
        long b = Math.abs((long) denominator);

        ret.append(a / b);
        a %= b;

        if (a == 0) {
            return ret.toString();
        }

        ret.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            if (map.containsKey(a)) {
                ret.insert(map.get(a), "(");
                ret.append(")");
                break;
            }

            map.put(a, ret.length());
            a = a * 10;
            ret.append(a / b);
            a %= b;
        }

        return ret.toString();
    }
}
