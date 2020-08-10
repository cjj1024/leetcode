/**
 * @author cuijunjie
 * @create 2020--10-14:42
 */
public class Solution {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2147483648;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        long N = n;
        return n >= 0 ? quickPow(x, n) : quickPow(1 / x, -N);
    }

    public static double quickPow(double x, long n) {
        double ret = 1.0;

        double t = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ret *= t;
            }
            t *= t;
            n /= 2;
        }

        return ret;
    }

//    public static double quickPow(double x, int n) {
//        if (n == 0) {
//            return 1.0;
//        }
//
//        double y = quickPow(x, n / 2);
//        return n % 2 == 0 ? y * y : y * y * x;
//    }

//    public static double myPow(double x, int n) {
//        if (n == 0) {
//            return 1;
//        }
//        if (n < 0) {
//            n = -n;
//            x = 1 / x;
//        }
//        double ret = x;
//        int i = 2;
//        for (; i < n; i *= 2) {
//            ret *= ret;
//        }
//        i /= 2;
//        for (; i < n; i++) {
//            ret *= x;
//        }
//
//        return ret;
//    }
}

