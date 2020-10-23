import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2020-10-22-17:29
 */
public class Solution {
    public static void main(String[] args) {
//        int[][] prerequisites = {
//                {1, 0},
//                {2, 0},
//                {3, 1},
//                {3, 2}
//        };
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {0, 1}
        };
        int[] order = findOrder(3, prerequisites);
        for (int i : order) {
            System.out.println(i);
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] edges = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int[] pq : prerequisites) {
            edges[pq[1]].add(pq[0]);
        }

        int visited[] = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        boolean valid = true;
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                valid = dfs(edges, visited, stack, i);
            }
            if (!valid) {
                return new int[]{};
            }
        }

        int[] ret = new int[numCourses];
        for (int i = 0; !stack.isEmpty(); i++) {
            ret[i] = stack.pop();
        }

        return ret;
    }

    private static boolean dfs(List<Integer>[] edges, int[] visited, Stack<Integer> stack, int u) {
        visited[u] = 1;
        boolean valid = true;
        for (int v : edges[u]) {
            if (visited[v] == 0) {
                valid = dfs(edges, visited, stack, v);
                if (!valid) {
                    return valid;
                }
            } else if (visited[v] == 1) {
                return false;
            }
        }
        visited[u] = 2;
        stack.push(u);

        return valid;
    }
}
