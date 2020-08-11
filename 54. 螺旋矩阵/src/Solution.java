import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--11-10:47
 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> list = spiralOrder(matrix);
        list.forEach(System.out::println);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (matrix.length < 1) {
            return ret;
        }

        ret.addAll(getRound(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1));

        return ret;
    }

    public static List<Integer> getRound(int[][] matrix, int leftUpX, int leftUpY, int rightDownX, int rightDownY) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (leftUpX > rightDownX || leftUpY > rightDownY) {
            return ret;
        }
        if (leftUpX == rightDownX) {
            for (int i = leftUpY; i <= rightDownY; i++) {
                ret.add(matrix[leftUpX][i]);
            }
            return ret;
        } else if (leftUpY == rightDownY) {
            for (int i = leftUpX; i <= rightDownX; i++) {
                ret.add(matrix[i][leftUpY]);
            }
            return ret;
        }

        for (int i = leftUpY; i < rightDownY; i++) {
            ret.add(matrix[leftUpX][i]);
        }
        for (int i = leftUpX; i < rightDownX; i++) {
            ret.add(matrix[i][rightDownY]);
        }
        for (int i = rightDownY; i > leftUpY; i--) {
            ret.add(matrix[rightDownX][i]);
        }
        for (int i = rightDownX; i > leftUpX; i--) {
            ret.add(matrix[i][leftUpY]);
        }
        ret.addAll(getRound(matrix, leftUpX + 1, leftUpY + 1, rightDownX - 1, rightDownY - 1));
        return ret;
    }
}
