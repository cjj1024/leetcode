/**
 * @author cuijunjie
 * @create 2020--10-16:30
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

    public static int totalNQueens(int n) {

        int ret = dfs(n, 0, 0, 0, 0, 0);

        return ret;
    }


    static int dfs(int n, int row, int col, int diagLeft, int diagRight, int num) {
        if (row >= n) {
            num++;
            return num;
        }

        int free = ~(col | diagLeft | diagRight) & ((1 << n) - 1);
        while (free > 0) {
            int pick = free & -free;
            num = dfs(n, row + 1, col | pick, (diagLeft | pick) << 1, (diagRight | pick) >> 1, num);
            free &= free - 1;
        }

        return num;
    }

//    public static int totalNQueens(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        boolean[][] board = new boolean[n][n];
//        return backtrace(n, board, 0);
//    }

//    public static int backtrace(int n, boolean[][] board, int row) {
//        if (row == n) {
//            return  1;
//        }
//        int num = 0;
//        for (int i = 0; i < n; i++) {
//            if (isValid(n, board, row, i)) {
//                board[row][i] = true;
//                num += backtrace(n, board, row + 1);
//                board[row][i] = false;
//            }
//        }
//
//        return num;
//    }
//
//    public static boolean isValid(int n, boolean[][] board, int row, int col) {
//        for (int i = 0; i < n; i++) {
//            if (board[i][col]) {
//                return false;
//            }
//            if (board[row][i]) {
//                return false;
//            }
//        }
//
//        int i = row - 1;
//        int j = col - 1;
//        while (i >= 0 && j >= 0) {
//            if (board[i][j]) {
//                return false;
//            }
//            i--;
//            j--;
//        }
//        i = row - 1;
//        j = col + 1;
//        while (i >= 0 && j < n) {
//            if (board[i][j]) {
//                return false;
//            }
//            i--;
//            j++;
//        }
//
//        return true;
//    }
}
