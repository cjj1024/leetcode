import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2020-10-20-10:09
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        int count = 0;
        boolean[] signs = new boolean[n];
        Arrays.fill(signs, true);
        for (int i = 2; i < n; i++) {
            if (signs[i]) {
                count++;
                for (int j = i + i; j < n; j += i) {
                    signs[j] = false;
                }
            }
        }

        return count;
    }

//    public static int countPrimes(int n) {
//        if (n < 3) {
//            return 0;
//        }
//        int count = 1;
//        for (int i = 3; i < n; i++) {
//            boolean flag = true;
//            if ((i & 1) == 0) {
//                continue;
//            }
//            for (int j = 2; j <= Math.sqrt(i); j++) {
//                if (i % j == 0) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                count++;
//            }
//        }
//
//        return count;
//    }
}
