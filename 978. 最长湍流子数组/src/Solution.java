import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2021/3/12-11:13
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
        System.out.println(maxTurbulenceSize(new int[]{4,8,12,16}));
        System.out.println(maxTurbulenceSize(new int[]{100}));
        System.out.println(maxTurbulenceSize(new int[]{4, 5}));
        System.out.println(maxTurbulenceSize(new int[]{9, 9}));

        System.out.println(maxTurbulenceSize(new int[]{37,199,60,296,257,248,115,31,273,176}));
    }

    public static int maxTurbulenceSize(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }

        int[] dp1 = new int[arr.length];
        int[] dp2 = new int[arr.length];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1] && i % 2 == 0) {
                dp1[i] = dp1[i - 1] + 1;
            } else if (arr[i] < arr[i - 1] && i % 2 == 1) {
                dp1[i] = dp1[i - 1] + 1;
            } else if (arr[i] > arr[i - 1] && i % 2 == 1) {
                dp2[i] = dp2[i - 1] + 1;
            } else if (arr[i] < arr[i - 1] && i % 2 == 0) {
                dp2[i] = dp2[i - 1] + 1;
            } else {
                dp1[i] = 1;
                dp2[i] = 1;
            }
        }

        return Math.max(Arrays.stream(dp1).max().getAsInt(), Arrays.stream(dp2).max().getAsInt());
    }

//    public static int maxTurbulenceSize(int[] arr) {
//        if (arr == null || arr.length < 1) {
//            return 0;
//        }
//        if (arr.length == 1) {
//            return 1;
//        }
//
//        int sign = 1;
//        int maxLen = 1;
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] > arr[i - 1]) {
//                sign = 1;
//            } else if (arr[i] < arr[i - 1]) {
//                sign = -1;
//            } else {
//                continue;
//            }
//            int len = 2;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (sign == 1 && arr[j] < arr[j - 1]) {
//                    sign = -1;
//                    len++;
//                } else if (sign == -1 && arr[j] > arr[j - 1]) {
//                    sign = 1;
//                    len++;
//                } else {
//                    break;
//                }
//            }
//            maxLen = Math.max(maxLen, len);
//        }
//
//        return maxLen;
//    }
}
