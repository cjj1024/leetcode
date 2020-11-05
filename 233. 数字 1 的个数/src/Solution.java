/**
 * @author CuiJunJie
 * @create 2020-11-05-10:24
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(countDigitOne(1410065408));
    }

    public static int countDigitOne(int n) {
        long x;
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            x = i * 10;
            count += (n / x) * i + Math.min(Math.max(n % x - i + 1, 0), i);
        }

        return count;
    }
}
