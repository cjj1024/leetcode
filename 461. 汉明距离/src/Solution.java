/**
 * @author CuiJunJie
 * @create 2021/5/27-9:17
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance(1, 3));      // 2
    }

    public static int hammingDistance(int x, int y) {
        int dist = 0;
        while (x != 0 || y != 0) {
            if ((x % 2) != (y % 2)) {
                dist++;
            }

            x = x / 2;
            y = y / 2;
        }

        return dist;
    }
}
