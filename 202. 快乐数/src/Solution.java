import java.util.HashSet;

/**
 * @author CuiJunJie
 * @create 2020-10-19-17:26
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (!set.contains(n) && n != 1) {
            set.add(n);
            int sum = 0;
            while (n != 0) {
                sum = sum + (int) Math.pow((n % 10), 2);
                n = n / 10;
            }
            n = sum;
        }

        return n == 1;
    }
}
