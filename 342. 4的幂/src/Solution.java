/**
 * @author CuiJunJie
 * @create 2021/5/31-9:19
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
    }

    public static boolean isPowerOfFour(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        while (true) {
            if (n / 4 * 4 != n) {
                return false;
            }
            n = n / 4;
            if (n == 1) {
                return true;
            }
        }
    }
}
