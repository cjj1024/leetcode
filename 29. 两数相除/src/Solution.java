/**
 * @author cuijunjie
 * @create 2020--04-17:09
 */
public class Solution {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = -1;
        System.out.println(divide(dividend, divisor));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) return dividend;
        if (divisor == -1) return  -dividend;

        int sign = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            sign = -1;
        }

        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;

        if (a > b) return 0;

        int ret = div(a, b);
        return sign == 1 ? ret : -ret;

    }

    public static int div(int a, int b) {
        if (a > b) {
            return 0;
        }

        int count = 1;
        int tb = b;
        while (tb + tb >= a && tb + tb < 0) {
            tb += tb;
            count += count;
        }

        return count + div(a - tb, b);
    }
}
