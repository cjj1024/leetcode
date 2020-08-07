import java.util.BitSet;

/**
 * @author cuijunjie
 * @create 2020--06-18:14
 */
public class Solution {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solveSudoku(board);

        System.out.println(isValidSudoku(board));
    }
    static BitSet[] row = new BitSet[9];
    static BitSet[] col = new BitSet[9];
    static BitSet[] sub = new BitSet[9];
    public static void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            row[i] = new BitSet(9);
            col[i] = new BitSet(9);
            sub[i] = new BitSet(9);
        }

        int x = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                x = board[i][j] - '1';
                if (x >= 0 && x < 9) {
                    row[i].set(x);
                    col[j].set(x);
                    sub[i / 3 * 3 + j / 3].set(x);
                }
            }
        }

        backtrace(board, 0, 0);
    }

    public static boolean backtrace(char[][] board, int i, int j) {
        if (j == 9) {
            return backtrace(board, i + 1, 0);
        }
        if (i == 9) {
            return true;
        }
        if (board[i][j] != '.') {
            return backtrace(board, i, j + 1);
        } else {
            BitSet rem = new BitSet(9);
            rem.or(row[i]);
            rem.or(col[j]);
            rem.or(sub[i / 3 * 3 + j / 3]);
            for (int k = 0; k < 9; k++) {
                if (!rem.get(k)) {
                    row[i].set(k);
                    col[j].set(k);
                    sub[i / 3 * 3 + j / 3].set(k);
                    board[i][j] = (char) (k + '1');
                    if (backtrace(board, i, j + 1)) {
                        return true;
                    }
                    row[i].clear(k);
                    col[j].clear(k);
                    sub[i / 3 * 3 + j / 3].clear(k);
                    board[i][j] = '.';
                }
            }
        }

        return false;
    }

//    public static void solveSudoku(char[][] board) {
//        backtrace(board, 0, 0);
//    }
//
//    public static boolean backtrace(char[][] board, int i, int j) {
//        if (j == 9) {
//            return backtrace(board, i + 1, 0);
//        }
//        if (i == 9) {
//            return true;
//        }
//        if (board[i][j] != '.') {
//            return backtrace(board, i, j + 1);
//        } else {
//            for (char c = '1'; c <= '9'; c++) {
//                if (isValid(board, i, j, c)) {
//                    board[i][j] = c;
//                    if (backtrace(board, i, j + 1)) {
//                        return true;
//                    }
//                    board[i][j] = '.';
//                }
//            }
//        }
//
//        return false;
//    }
//
//    public static boolean isValid(char[][] board, int i, int j, char c) {
//        for (int k = 0; k < 9; k++) {
//            if (board[i][k] == c) {
//                return false;
//            } else if (board[k][j] == c) {
//                return false;
//            } else if (board[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3] == c) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] sub = new int[9][9];
        int x = 0;
        int subIdx = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                x = board[i][j] - '1';
                subIdx = i / 3 * 3 + j / 3;
                if (x >= 0 && x < 9) {
                    row[i][x] += 1;
                    col[j][x] += 1;
                    sub[subIdx][x] += 1;
                    if (row[i][x] > 1 || col[j][x] > 1 || sub[subIdx][x]> 1) {
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
