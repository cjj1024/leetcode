/**
 * @author CuiJunJie
 * @create 2020/11/27-15:37
 */
public class Solution {
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(board);

        for (int[] row : board) {
            for (int x : row) {
                System.out.printf("%d ", x);
            }
            System.out.println();
        }
    }

    public static void gameOfLife(int[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }

        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num = 0;
                if (i - 1 >= 0) {
                    num += board[i - 1][j];
                    if (j - 1 >= 0) {
                        num += board[i - 1][j - 1];
                    }
                    if (j + 1 < board[0].length) {
                        num += board[i - 1][j + 1];
                    }
                }
                if (i + 1 < board.length) {
                    num += board[i + 1][j];
                    if (j - 1 >= 0) {
                        num += board[i + 1][j - 1];
                    }
                    if (j + 1 < board[0].length) {
                        num += board[i + 1][j + 1];
                    }
                }
                if (j - 1 >= 0) {
                    num += board[i][j - 1];
                }
                if (j + 1 < board[0].length) {
                    num += board[i][j + 1];
                }

                if (num < 2) {
                    newBoard[i][j] = 0;
                } else if (num == 2 && board[i][j] == 1) {
                    newBoard[i][j] = 1;
                } else if (num == 3) {
                    newBoard[i][j] = 1;
                } else if (num > 3) {
                    newBoard[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }
}
