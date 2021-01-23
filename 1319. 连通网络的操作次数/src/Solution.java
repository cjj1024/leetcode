import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @create CuiJunJie
 * @date 2021/1/23-20:36
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
    }

    public static int makeConnected(int n, int[][] connections) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int[] conn : connections) {
            union(parents, conn[0], conn[1]);
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < parents.length; i++) {
            set.add(find(parents, i));
        }

        return connections.length >= n - 1 ? set.size() - 1 : -1;
    }

    private static void union(int[] parents, int x, int y) {
        int xRoot = find(parents, x);
        int yRoot = find(parents, y);

        if (xRoot != yRoot) {
            parents[yRoot] = xRoot;
        }
    }

    private static int find(int[] parents, int x) {
        if (x != parents[x]) {
            parents[x] = find(parents, parents[x]);
        }

        return parents[x];
    }
}
