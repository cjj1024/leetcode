import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020-11-10-9:59
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1407));
    }

    public static int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
    }

//    private static Ugly ugly = new Ugly(1690);
//    public static int nthUglyNumber(int n) {
//        return ugly.get(n - 1);
//    }


//    public static int nthUglyNumber(int n) {
//        if (n == 1) {
//            return 1;
//        }
//
//        Set<Integer> set = new HashSet<>();
//        set.add(1);
//        int num = 0;
//        int i = 1;
//        while (true) {
//            if (set.contains(i)) {
//                num++;
//                set.add(i * 2);
//                set.add(i * 3);
//                set.add(i * 5);
//            }
//            if (num == n) {
//                return i;
//            }
//            i++;
//        }
//    }

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