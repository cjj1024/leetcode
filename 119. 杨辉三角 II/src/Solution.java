import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-09-01-16:16
 */
public class Solution {
    public static void main(String[] args) {
        List<Integer> row = getRow(33);
        row.forEach(System.out::println);
    }

    public static List<Integer> getRow(int rowIndex) {
        rowIndex = rowIndex + 1;
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 1) {
            return list;
        }
        list.add(1);
        for (int i = 1; i < rowIndex; i++) {
            list.add((int) ((long) list.get(i - 1) * (rowIndex - i) / i));
        }

        return list;
    }
}
