/**
 * @author CuiJunJie
 * @create 2021/1/7-9:41
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public static int findCircleNum(int[][] isConnected) {
        int num = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                num++;
            }
        }

        return num;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int v) {
        visited[v] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i] && isConnected[v][i] == 1) {
                dfs(isConnected, visited, i);
            }
        }
    }
}
