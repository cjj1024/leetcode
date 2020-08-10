import java.util.ArrayList;
import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--10-15:36
 */
public class Solution {
    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        if (n < 1) {
            return ret;
        }

        boolean[][] board= new boolean[n][n];
        backtrace(n, board, 0, ret);

        return ret;
    }

    public static void backtrace(int n, boolean[][] board, int row, List<List<String>> ret) {
        if (row == n) {
            StringBuilder sb = new StringBuilder(n);
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
                sb.setLength(0);
            }
            ret.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(board, row, i)) {
                board[row][i] = true;
                backtrace(n, board, row + 1, ret);
                board[row][i] = false;
            }
        }
    }

    public static boolean isValid(boolean[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i]) {
                return false;
            }
            if (board[i][col]) {
                return false;
            }
        }
        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j--;
        }
        i = row;
        j = col;
        while (i >= 0 && j < board.length) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
