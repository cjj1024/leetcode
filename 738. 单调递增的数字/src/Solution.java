import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020/12/15-9:34
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(10));
        System.out.println(monotoneIncreasingDigits(1234));
        System.out.println(monotoneIncreasingDigits(332));
        System.out.println(monotoneIncreasingDigits(100));
        System.out.println(monotoneIncreasingDigits(989998));
    }

    public static int monotoneIncreasingDigits(int N) {
        List<Integer> list = new ArrayList<>();
        while (N > 0) {
            list.add(N % 10);
            N /= 10;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                list.set(i, 9);
                list.set(i + 1, list.get(i + 1) - 1);
                for (int j = 0; j < i; j++) {
                    int diff = list.get(i) - list.get(j);
                    if (diff > 0) {
                        for (int k = j; k < i; k++) {
                            list.set(k, list.get(k) + diff);
                        }
                    }
                }
            }
        }

        int ret = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            ret = ret * 10 + list.get(i);
        }

        return ret;
    }
}
