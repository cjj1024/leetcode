import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020-10-28-15:22
 */
public class Solution {
    public static void main(String[] args) {
//        int[][] buildings = {
//                {2, 9, 10},
//                {3, 7, 15},
//                {5, 12, 12},
//                {15, 20, 10},
//                {19, 24, 8}
//        };
        int[][] buildings = {
                {0, 2, 3},
                {2, 5, 3}
        };

        List<List<Integer>> skyline = getSkyline(buildings);
        for (List<Integer> list : skyline) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length < 1) {
            return new ArrayList<>();
        }

        List<List<Integer>> ret = new ArrayList<>();

        PriorityQueue<int[]> all = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        for (int[] building : buildings) {
            all.offer(new int[]{building[0], -building[2]});
            all.offer(new int[]{building[1], building[2]});
        }

        TreeMap<Integer, Integer> heights = new TreeMap<>((o1, o2) -> o2 - o1);
        int maxHeight = Integer.MIN_VALUE;
        heights.put(0, 0);
        while (!all.isEmpty()) {
            int[] now = all.poll();
            if (now[1] < 0) {
                heights.put(-now[1], heights.getOrDefault(-now[1], 0) + 1);
            } else {
                heights.put(now[1], heights.get(now[1]) - 1);
                if (heights.get(now[1]) == 0) {
                    heights.remove(now[1]);
                }
            }

            if (!heights.isEmpty() && maxHeight != heights.firstKey()) {
                maxHeight = heights.firstKey();
                ret.add(Arrays.asList(now[0], maxHeight));
            }
        }

        return ret;
    }
}
