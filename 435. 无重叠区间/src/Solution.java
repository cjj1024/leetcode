import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020/12/31-9:40
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 1 || intervals[0] == null || intervals[0].length < 1) {
            return 0;
        }

        Arrays.sort(intervals, ((o1, o2) -> o1[1] - o2[1]));

        int right = intervals[0][1];
        int removeNum = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < right) {
                removeNum++;
            } else {
                right = intervals[i][1];
            }
        }

        return removeNum;
    }
}
