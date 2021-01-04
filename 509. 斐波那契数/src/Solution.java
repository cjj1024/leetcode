import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2021/1/4-15:08
 */
public class Solution {
    private static Map<Integer, Integer> map = new HashMap<>();
    static {
        map.put(0, 0);
        map.put(1, 1);
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
    }

    public static int fib(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        return fib(n - 1) + fib(n - 2);
    }
}
