/**
 * @author CuiJunJie
 * @create 2020-11-05-9:55
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(32));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(31));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        long x = (long) n;
        return (x & (x - 1)) == 0;
    }

//    public static boolean isPowerOfTwo(int n) {
//        if (n == 0) {
//            return false;
//        }
//        while (n % 2 == 0) {
//            n = n / 2;
//        }
//        return n == 1;
//    }

//    public static boolean isPowerOfTwo(int n) {
//        while ((n | 1) != n) {
//            n = n >> 1;
//        }
//
//        return (n >> 1) == 0;
//    }
}
