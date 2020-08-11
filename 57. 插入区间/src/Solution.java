import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author cuijunjie
 * @create 2020--11-15:35
 */
public class Solution {
    public static void main(String[] args) {
//        int[][] intervals = {
//                {1, 3},
//                {6, 9}
//        };
//        int[] newInterval = {2, 5};
//        [[1,2],[3,5],[6,7],[8,10],[12,16]]
//        int[][] intervals = {
//                {1, 2},
//                {3, 5},
//                {6, 7},
//                {8, 10},
//                {12, 16}
//        };
        int[][] intervals = {
                {1, 5}
        };
//        int[][] intervals = {
//                {0, 5},
//                {9, 12}
//        };
        int[] newInterval = {6, 8};

        int[][] ret = insert(intervals, newInterval);
        for (int[] row : ret) {
            for (int x : row) {
                System.out.print(x);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length < 1) {
            int[][] ret = new int[1][];
            ret[0] = newInterval;
            return ret;
        }

        ArrayList<int[]> ret = new ArrayList<>();

        int left = 0;
        while (left < intervals.length && intervals[left][1] < newInterval[0]) {
            left++;
        }
        int right = intervals.length - 1;
        while (right >= 0 && intervals[right][0] > newInterval[1]) {
            right--;
        }
        int l = left < intervals.length ? Math.min(intervals[left][0], newInterval[0]) : newInterval[0];
        int r = right >= 0 ? Math.max(intervals[right][1], newInterval[1]) : newInterval[1];
        for (int i = 0; i < left; i++) {
            ret.add(intervals[i]);
        }
        ret.add(new int[]{l, r});
        for (int j = right + 1; j < intervals.length; j++) {
            ret.add(intervals[j]);
        }

        int[][] ret2 = new int[ret.size()][2];
        for (int    i = 0; i < ret2.length; i++) {
            for (int j = 0; j < 2; j++) {
                ret2[i][j] = ret.get(i)[j];
            }
        }

        return ret2;
    }
}
