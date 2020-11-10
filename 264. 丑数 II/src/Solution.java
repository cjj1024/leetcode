import java.util.HashSet;
import java.util.Set;

/**
 * @author CuiJunJie
 * @create 2020-11-10-9:59
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    private static Ugly ugly = new Ugly(1690);
    public static int nthUglyNumber(int n) {
        return ugly.get(n - 1);
    }

//    public static int nthUglyNumber(int n) {
//        if (n < 7) {
//            return n;
//        }
//
//        Set<Integer> set = new HashSet<>();
//        int i = 1;
//        for (; i < 7; i++) {
//            set.add(i);
//        }
//        int num = 6;
//        while (num < n) {
//            if (i % 2 == 0 && set.contains(i / 2) ||
//            i % 3 == 0 && set.contains(i / 3) ||
//            i % 5 == 0 && set.contains(i / 5)) {
//                num++;
//                set.add(i);
//            }
//            i++;
//        }
//
//        return i - 1;
//    }
}