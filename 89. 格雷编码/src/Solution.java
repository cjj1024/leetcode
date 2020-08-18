import java.util.ArrayList;
import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--18-16:58
 */
public class Solution {
    public static void main(String[] args) {
        List<Integer> list = grayCode(3);
        list.forEach(System.out::println);
    }

    public static List<Integer> grayCode(int n) {
        ArrayList<Integer> ret = new ArrayList<>(2 ^ n);
        ret.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = ret.size() - 1; j >= 0; j--) {
                ret.add(head + ret.get(j));
            }
            head = head << 1;
        }

        return ret;
    }
}
