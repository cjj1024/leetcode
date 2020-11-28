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

    }
}
