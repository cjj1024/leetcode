/**
 * @author CuiJunJie
 * @create 2020-10-10-15:28
 */
public class Solution {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(hammingWeight(n));
    }

    public static int hammingWeight(int n) {
        int x = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((x & n) == x) {
                count++;
            }
            x = x << 1;
        }

        return count;
    }
}
