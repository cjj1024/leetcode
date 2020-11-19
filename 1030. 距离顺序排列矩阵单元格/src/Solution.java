import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020-11-17-9:19
 */
public class Solution {
    public static void main(String[] args) {
//        int R = 2, C = 2, r0 = 0, c0 = 1;
//        int R = 2, C = 3, r0 = 1, c0 = 2;
        int R = 3, C = 4, r0 = 0, c0 = 1;
        int[][] points = allCellsDistOrder(R, C, r0, c0);
        for (int[] point : points) {
            System.out.printf("%d %d\n", point[0], point[1]);
        }
    }

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int[][] points = new int[R * C][2];
        int maxLen = Math.max(Math.abs(R - r0), r0) + Math.max(Math.abs(C - c0), c0);
        int index = 0;
        points[index][0] = r0;
        points[index++][1] = c0;
        for (int k = 1; k <= maxLen; k++) {
            for (int i = 0, j = k; i <= k; i++, j--) {
                if (i == 0) {
                    if (put(points, index, r0, c0 + j, R, C)) {
                        index++;
                    }
                    if (put(points, index, r0, c0 - j, R, C)) {
                        index++;
                    }
                    continue;
                }
                if (j == 0) {
                    if (put(points, index, r0 + i, c0, R, C)) {
                        index++;
                    }
                    if (put(points, index, r0 - i, c0, R, C)) {
                        index++;
                    }
                    continue;
                }
                if (put(points, index, r0 + i, c0 + j, R, C)) {
                    index++;
                }
                if (put(points, index, r0 + i, c0 - j, R, C)) {
                    index++;
                }
                if (put(points, index, r0 - i, c0 + j, R, C)) {
                    index++;
                }
                if (put(points, index, r0 - i, c0 - j, R, C)) {
                    index++;
                }
            }
        }

        return points;
    }

    private static boolean put(int[][] points, int index, int i, int j, int R, int C) {
        if (i < 0 || j < 0 || i >= R || j >= C) {
            return false;
        }

        points[index][0] = i;
        points[index][1] = j;

        return true;
    }
}
