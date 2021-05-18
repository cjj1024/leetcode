/**
 * @author CuiJunJie
 * @create 2021/5/18-9:34
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{2, 3, 1, 6, 7}));    // 4
        System.out.println(countTriplets(new int[]{1,1,1,1,1}));        // 10
        System.out.println(countTriplets(new int[]{2,3}));              // 0
        System.out.println(countTriplets(new int[]{1,3,5,7,9}));       // 3
    }

    public static int countTriplets(int[] arr) {
        int len = arr.length;
        int[] xors = new int[len + 1];

        for (int i = 0; i < len; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }

        int count = 0;
        for (int i = 1; i <= len; i++) {
            for (int k = i + 1; k <= len; k++) {
                for (int j = i + 1; j <= k; j++) {
                    if ((xors[j - 1] ^ xors[i - 1]) == (xors[k] ^ xors[j - 1])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
