import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2021/5/12-9:42
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}})));
        System.out.println(Arrays.toString(xorQueries(new int[]{4, 8, 2, 10}, new int[][]{{2, 3}, {1, 3}, {0, 0}, {0, 3}})));
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] xorSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            xorSum[i + 1] = xorSum[i] ^ arr[i];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = xorSum[queries[i][1] + 1] ^ xorSum[queries[i][0]];
        }

        return res;
    }
}
