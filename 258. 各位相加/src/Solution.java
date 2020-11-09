/**
 * @author CuiJunJie
 * @create 2020-11-09-15:44
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(addDigits(19));
    }

    public static int addDigits(int num) {
        int ret = 0;
        do {
            while (num != 0) {
                ret += num % 10;
                num = num / 10;
            }
            num = ret;
            ret = 0;
        } while (num >= 10);

        return num;
    }
}
