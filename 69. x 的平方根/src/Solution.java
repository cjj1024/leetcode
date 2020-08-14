/**
 * @author cuijunjie
 * @create 2020--13-15:42
 */
public class Solution {
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(mySqrt(i) ==  Math.floor(Math.sqrt(i)));
//        }
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(xi - x0) < 1e-7) {
                break;
            }
            x0 = xi;
        }

        return (int) x0;
    }

//    public static int mySqrt(int x) {
//        if (x == 0) {
//            return 0;
//        }
//        long left = 1;
//        long right = x;
//        long mid = 0;
//        long square = 0;
//        while (left <= right) {
//            mid = (left + right) / 2;
//            square = mid * mid;
//            if (square < x) {
//                left = mid + 1;
//            } else if (square > x) {
//                right = mid - 1;
//            } else {
//                return (int) mid;
//            }
//        }
//
//        return (int) Math.min(left, right);
//    }

//    public static int mySqrt(int x) {
//        int ret = 1;
//        while (ret * ret < x) {
//            ret += 1;
//        }
//        if (ret * ret > x) {
//            ret -= 1;
//        }
//
//        return ret;
//    }
}
