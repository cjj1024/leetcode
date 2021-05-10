/**
 * @author CuiJunJie
 * @create 2021/5/7-9:26
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
        System.out.println(xorOperation(4, 3));
        System.out.println(xorOperation(1, 7));
        System.out.println(xorOperation(10, 5));
    }

    public static int xorOperation(int n, int start) {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = ret ^ (start + 2 * i);
        }

        return ret;
    }
}
