/**
 * @author CuiJunJie
 * @create 2020-10-17-15:17
 */
public class Solution {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind unionFind = new UnionFind(m * n + 1);

        int dummy = m * n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    unionFind.union(i * n + j, dummy);
                } else {
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        unionFind.union(i * n + j, (i + 1) * n + j);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        unionFind.union(i * n + j, i * n + j +1);
                    }
                }
            }
        }


        return unionFind.getCount() - 1;
    }


//    public static int numIslands(char[][] grid) {
//        int count = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '1') {
//                    count++;
//                }
//                dfs(grid, i, j);
//            }
//        }
//
//        return count;
//    }
//
//    public static void dfs(char[][] grid, int i, int j) {
//        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == '0') {
//            return;
//        }
//
//        grid[i][j] = '0';
//
//        dfs(grid, i + 1, j);
//        dfs(grid, i - 1, j);
//        dfs(grid, i, j + 1);
//        dfs(grid, i, j - 1);
//    }

}
