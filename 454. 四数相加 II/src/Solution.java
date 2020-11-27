import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author CuiJunJie
 * @create 2020/11/27-10:19
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null ||
                A.length < 1 || B.length < 1 || C.length < 1 || D.length < 1) {
            return 0;
        }

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num1 : A) {
            for (int num2 : B) {
                int sum = num1 + num2;
                map1.put(sum, map1.getOrDefault(sum, 0) + 1);
            }
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num1 : C) {
            for (int num2 : D) {
                int sum = num1 + num2;
                map2.put(sum, map2.getOrDefault(sum, 0) + 1);
            }
        }

        int num = 0;
        for (int num1 : map1.keySet()) {
            if (map2.containsKey(-num1)) {
                num += map1.get(num1) * map2.get(-num1);
            }
        }

        return num;

    }

//    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//        if (A == null || B == null || C == null || D == null ||
//                A.length < 1 || B.length < 1 || C.length < 1 || D.length < 1) {
//            return 0;
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : D) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        int num = 0;
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < B.length; j++) {
//                for (int k = 0; k < C.length; k++) {
//                    int x = -(A[i] + B[j] + C[k]);
//                    if (map.get(x) != null) {
//                        num += map.get(x);
//                    }
//                }
//            }
//        }
//
//        return num;
//
//    }

//    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//        if (A == null || B == null || C == null || D == null ||
//                A.length < 1 || B.length < 1 || C.length < 1 || D.length < 1) {
//            return 0;
//        }
//
//        int num = 0;
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < B.length; j++) {
//                for (int k = 0; k < C.length; k++) {
//                    for (int v = 0; v < D.length; v++) {
//                        if (A[i] + B[j] + C[k] + D[v] == 0) {
//                            num++;
//                        }
//                    }
//                }
//            }
//        }
//
//        return num;
//    }

}
