import org.omg.CORBA.ARG_IN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020/11/23-14:43
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, { 7, 12}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}}));
        System.out.println(findMinArrowShots(new int[][]{{2, 3}, {2, 3}}));
        System.out.println(findMinArrowShots(new int[][]{{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}}));
        System.out.println(findMinArrowShots(new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9},
                {3, 9}, {0, 6}, {2, 8}}));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length < 1 || points[0].length < 1) {
            return 0;
        }

        Arrays.sort(points, (p1, p2) -> p1[1] < p2[1] ? -1 : 1);
        int pre = points[0][1];
        int num = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pre) {
                num++;
                pre = points[i][1];
            }
        }

        return num;
    }
}
