import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-10-20-11:19
 */
public class Solution {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{
                {1, 2},
                {0, 1},
                {3, 1}
        };
        System.out.println(canFinish(4, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] edges = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] pq : prerequisites) {
            edges[pq[0]].add(pq[1]);
        }

        int[] visited = new int[numCourses];
        boolean valid = true;
        for (int i = 0; i < numCourses && valid; i++) {
            valid = dfs(edges, visited, i);
        }

        return valid;
    }

    public static boolean dfs(List<Integer>[] edges, int[] visited, int u) {
        visited[u] = 1;
        boolean valid = true;
        for (int v : edges[u]) {
            if (visited[v] == 0) {
                valid = dfs(edges, visited, v);
                if (!valid) {
                    return valid;
                }
            } else if (visited[v] == 1) {
                return false;
            }
        }

        visited[u] = 2;

        return valid;
    }
}
