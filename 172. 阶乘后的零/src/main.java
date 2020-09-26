/**
 * @author CuiJunJie
 * @create 2020-09-26-10:42
 */
public class main {
    public static void main(String[] args) {
        int n = 200;
        System.out.println(trailingZeroes(n));
    }

    public static int trailingZeroes(int n) {
        int five = 5;
        int count = 0;
        while (five <= n) {
            count += n / five;
            five *= 5;
        }

        return count;
    }
}
