/**
 * @author CuiJunJie
 * @create 2021/4/28-9:24
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(4));
        System.out.println(judgeSquareSum(3));
    }

    public static boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int x = left * left + right * right;
            if (x == c) {
                return true;
            } else if (x < c) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

//    public static boolean judgeSquareSum(int c) {
//        for (int i = 0; i <= Math.sqrt(c); i++) {
//            double j = Math.sqrt(c - i * i);
//            if (j - (int) j < 10e-7) {
//                return true;
//            }
//        }
//
//        return false;
//    }
}
