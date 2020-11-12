/**
 * @author CuiJunJie
 * @create 2020-11-12-10:00
 */
public class Solution {
    public static void main(String[] args) {
        int[] A = sortArrayByParityII(new int[]{4, 2, 5, 7});
        for (int i : A) {
            System.out.println(i);
        }
    }

    public static int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        while (true) {
            while (i < A.length && A[i] % 2 == 0) {
                i += 2;
            }
            while (j < A.length && A[j] % 2 == 1) {
                j += 2;
            }
            if (i >= A.length || j >= A.length) {
                break;
            }
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }

        return A;
    }
}
