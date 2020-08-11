import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author cuijunjie
 * @create 2020--11-14:32
 */
public class Solution {
    public static void main(String[] args) {
        //[[1,3],[2,6],[8,10],[15,18]]
//        int[][] intervals = {
//                {1, 3},
//                {8, 10},
//                {2, 6},
//                {15, 18}
//        };
        int[][] intervals = {
                {1, 4},
                {4, 5}
        };
        int[][] ret = merge(intervals);
        for (int[] row : ret) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        ArrayList<int[]> ret = new ArrayList<>();

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        ret.add(intervals[0]);
        int k = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > ret.get(k)[1]) {
                ret.add(intervals[i]);
                k++;
            } else {
                ret.get(k)[1] = Math.max(ret.get(k)[1], intervals[i][1]);
            }
        }

        int[][] ret2 = new int[ret.size()][2];
        for (int i = 0; i < ret2.length; i++) {
            for (int j = 0; j < 2; j++) {
                ret2[i][j] = ret.get(i)[j];
            }
        }

        return ret2;
    }
}
