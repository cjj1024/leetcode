import java.util.*;

/**
 * @author CuiJunJie
 * @create 2021/6/28-10:04
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(numBusesToDestination(new int[][]{{7,12},{4,5,15},{6},{15,19},{9,12,13}}, 15, 12));  // -1
        System.out.println(numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));     // 2
        System.out.println(numBusesToDestination(new int[][]{{1, 7}, {3, 5}}, 5, 5));       // 0
    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        List<Integer> starts = new ArrayList<>();
        List<Set<Integer>> route2Station = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            Set<Integer> stations = new HashSet<>();
            for (int j = 0; j < routes[i].length; j++) {
                stations.add(routes[i][j]);
                if (routes[i][j] == source) {
                    starts.add(i);
                }
            }
            route2Station.add(stations);
        }
        if (starts.size() == 0) {
            return -1;
        }

        int minStep = -1;
        for (int start : starts) {
            int step = 0;
            Set<Integer> seen = new HashSet<>();
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(start);
            boolean archive = false;
            while (!queue.isEmpty() && !archive) {
                step++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int route = queue.poll();
                    seen.add(route);
                    if (route2Station.get(route).contains(target)) {
                        archive = true;
                        break;
                    }
                    for (int nextRoute : getNextRoute(route, route2Station)) {
                        if (!seen.contains(nextRoute)) {
                            queue.offer(nextRoute);
                        }
                    }

                }

            }
            if (archive) {
                if (minStep == -1) {
                    minStep = step;
                } else {
                    minStep = Math.min(minStep, step);
                }
            }

        }

        return minStep;
    }

    private static Set<Integer> getNextRoute(int route, List<Set<Integer>> route2Station) {
        Set<Integer> nextRoute = new HashSet<>();
        Set<Integer> stations = route2Station.get(route);
        for (int station : stations) {
            for (int i = 0; i < route2Station.size(); i++) {
                if (route2Station.get(i).contains(station)) {
                    nextRoute.add(i);
                }
            }
        }
        return nextRoute;
    }
}
