import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @author CuiJunJie
 * @create 2020-11-03-16:18
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A > E) {
            return computeArea(E, F, G, H, A, B, C, D);
        }

        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        if (E >= C || F >= D || B >= H) {
            return area1 + area2;
        }

        int x1 = Math.max(A, E);
        int y1 = Math.max(B, F);
        int x2 = Math.min(C, G);
        int y2 = Math.min(D, H);

        return area1 + area2 - (x2 - x1) * (y2 - y1);
    }
}
