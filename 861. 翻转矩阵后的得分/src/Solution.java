/**
 * @author CuiJunJie
 * @create 2020/12/7-11:14
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
        System.out.println(matrixScore(new int[][]{{0, 1}, {1, 1}}));
    }

    public static int matrixScore(int[][] A) {
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[0].length; j++) {
                    if (A[i][j] == 0) {
                        A[i][j] = 1;
                    } else {
                        A[i][j] = 0;
                    }
                }
            }
        }
        for (int j = 0; j < A[0].length; j++) {
            num = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i][j] == 0) {
                    num++;
                }
            }
            if (num > A.length / 2) {
                for (int i = 0; i < A.length; i++) {
                    if (A[i][j] == 0) {
                        A[i][j] = 1;
                    } else {
                        A[i][j] = 0;
                    }
                }
                j--;
            }

        }

        int sum = 0;
        int base = 1;
        for (int j = A[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < A.length; i++) {
                sum += A[i][j] * base;
            }
            base *= 2;
        }

        return sum;
    }
}
