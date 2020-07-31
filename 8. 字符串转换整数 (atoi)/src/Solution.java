/**
 * @author cuijunjie
 * @create 2020--31-11:19
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483649"));
    }

    public static int myAtoi(String str) {
        if (str.length() == 0) return 0;

        char[] charArray = str.toCharArray();
        int len = charArray.length;
        int i = 0;
        int c;
        while (i < len && charArray[i] == ' ') {
            ++i;
        }
        if (i == len) {
            return 0;
        }

        int sign = 1;
        if (charArray[i] == '-') {
            sign = -1;
            ++i;
        } else if (charArray[i] == '+') {
            ++i;
        }

        int ret = 0;
        while (i < len) {
            c = charArray[i] - '0';
            if (c >= 0 && c <= 9) {
                if (sign == 1) {
                    if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && c > 7)) return Integer.MAX_VALUE;
                } else {
                    if (ret * sign < Integer.MIN_VALUE / 10 || (ret * sign == Integer.MIN_VALUE / 10 && c > 8)) return Integer.MIN_VALUE;
                }

                ret = ret * 10 + c;
                ++i;
            } else {
                break;
            }
        }

        return sign * ret;
    }
}
