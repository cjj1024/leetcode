import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2021/5/11-9:30
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decode(new int[]{6, 5, 4, 6})));     // [2,4,1,5,3]
        System.out.println(Arrays.toString(decode(new int[]{7, 5, 6, 11, 14, 15, 11, 6})));     // [6,1,4,2,9,7,8,3,5]
    }

    public static int[] decode(int[] encoded) {
        int n = encoded.length + 1;

        int start = 0;
        for (int i = 1; i <= n; i++) {
            start = start ^ i;
        }
        for (int i = 1; i < n - 1; i += 2) {
            start = start ^ encoded[i];
        }

        int[] decoded = new int[n];
        decoded[0] = start;
        for (int i = 1; i < n; i++) {
            decoded[i] = decoded[i - 1] ^ encoded[i - 1];
        }

        return decoded;
    }

//    public static int[] decode(int[] encoded) {
//        int n = encoded.length + 1;
//        boolean[] used = new boolean[n + 1];
//        int[] decoded = new int[n];
//
//        for (int i = 1; i <= n; i++) {
//            decoded[0] = i;
//            used[i] = true;
//            if (backtrace(encoded, used, decoded, 1, n)) {
//                break;
//            }
//            used[i] = false;
//        }
//
//        return decoded;
//    }
//
//    private static boolean backtrace(int[] encoded, boolean[] used, int[] decoded, int k, int n) {
//        if (k == n) {
//            return true;
//        }
//
//        int e = encoded[k - 1] ^ decoded[k - 1];
//        if (e > 0 && e <= n && !used[e]) {
//            used[e] = true;
//            decoded[k] = e;
//            if (backtrace(encoded, used, decoded, k + 1, n)) {
//                return true;
//            }
//            used[e] = false;
//        }
//
//        return false;
//    }
}
