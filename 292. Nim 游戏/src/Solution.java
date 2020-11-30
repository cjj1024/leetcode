/**
 * @author CuiJunJie
 * @create 2020/11/28-17:04
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(canWinNim(4));
    }

    public static boolean canWinNim(int n) {
        if (n < 0) {
            return false;
        }
        else if (n <= 3) {
            return true;
        } else {
            boolean ret = false;
            for (int i = 2; i < 6; i++) {
                ret = ret | canWinNim(n - i);
            }
            return ret;
        }
    }
}
