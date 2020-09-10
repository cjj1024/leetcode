/**
 * @author CuiJunJie
 * @create 2020-09-09-15:56
 */
public class Solution {
    public static void main(String[] args) {
//        char[][] board = {
//            {
//                'X', 'X', 'X', 'X'
//            },
//            {
//                'X', 'O', 'O', 'X'
//            },
//            {
//                'X', 'X', 'O', 'X'
//            },
//            {
//                'X', 'O', 'X', 'X'
//            }
//        };
//        char[][] board = {
//                {'X', 'O', 'X', 'X'},
//                {'O', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'O'},
//                {'O', 'X', 'O', 'X'}
//        };
        char[][] board = {
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
        };

        solve(board);
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.printf("%c ", aChar);
            }
            System.out.println();
        }
    }

    public static void solve(char[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
        }
        for (int i = 0; i < m; i++) {
            dfs(board, i, n - 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        if (board[i][j] == 'O') {
            board[i][j] = 'A';
            dfs(board, i - 1, j);
            dfs(board, i + 1, j);
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);
        }
    }
}
