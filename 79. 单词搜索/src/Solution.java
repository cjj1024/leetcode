/**
 * @author cuijunjie
 * @create 2020--15-15:28
 */
public class Solution {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
//        char[][] board = {
//                {'A', 'B'},
//                {'C', 'D'}
//        };
        String word = "CCEESEA";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return false;
        }
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrace(board, word, used, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backtrace(char[][] board, String word, boolean[][] used, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || j < 0) {
            return false;
        }
        if (j == board[0].length) {
            return false;
        }
        if (i == board.length) {
            return false;
        }
        
        if (!used[i][j] && board[i][j] == word.charAt(k)) {
            used[i][j] = true;
            if (backtrace(board, word, used, i - 1, j, k + 1)) {
                return true;
            }
            if (backtrace(board, word, used, i, j - 1, k + 1)) {
                return true;
            }
            if (backtrace(board, word, used, i + 1, j, k + 1)) {
                return true;
            }
            if (backtrace(board, word, used, i, j + 1, k + 1)) {
                return true;
            }
            used[i][j] = false;
        }

        return false;
    }
}
