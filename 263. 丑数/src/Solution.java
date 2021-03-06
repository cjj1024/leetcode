/**
 * @author CuiJunJie
 * @create 2020-11-10-9:53
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(14));
    }

    public static boolean isUgly(int n) {
        boolean flag = true;
        while (n > 0 && flag) {
            flag = false;
            while (n % 5 == 0) {
                n /= 5;
                flag = true;
            }
            while (n % 3 == 0) {
                n /= 3;
                flag = true;
            }
            while (n % 2 == 0) {
                n /= 2;
                flag = true;
            }
        }

        return n == 1;
    }

//    public static boolean isUgly(int num) {
//        if (num == 0) {
//            return false;
//        }
//
//        while (num % 2 == 0) {
//            num = num / 2;
//        }
//        while (num % 3 == 0) {
//            num = num / 3;
//        }
//        while (num % 5 == 0) {
//            num = num / 5;
//        }
//
//        return num == 1;
//    }
}
