/**
 * @author CuiJunJie
 * @create 2020/11/28-17:04
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(canWinNim(4));
    }

    public static boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}
