import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-09-01-16:08
 */
public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> lists = generate(5);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.printf("%d ", integer);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();

        if (numRows < 1) {
            return lists;
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        lists.add(list);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list2 = new ArrayList<>();
            list2.add(1);
            for (int j = 0; j < list.size() - 1; j++) {
                list2.add(list.get(j) + list.get(j + 1));
            }
            list2.add(1);
            lists.add(list2);
            list = list2;
        }

        return lists;
    }
}
