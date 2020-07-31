

/**
 * @author cuijunjie
 * @create 2020--31-10:05
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {

        int ret = 0;

        while (x != 0) {
            int end = x % 10;
            x = x / 10;
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && end > 7)) return 0;
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && end < -8)) return 0;

            ret = ret * 10 + end;
        }


        return ret;
    }
}
