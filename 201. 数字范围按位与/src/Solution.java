/**
 * @author CuiJunJie
 * @create 2020-10-19-15:04
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m < n) {
            m = m >> 1;
            n = n >> 1;
            shift++;
        }

        return m << shift;
    }

//    public static int rangeBitwiseAnd(int m, int n) {
//        int ret = n;
//        for (int i = m; i < n; i++) {
//            ret = ret & i;
//        }
//
//        return ret;
//    }
}
