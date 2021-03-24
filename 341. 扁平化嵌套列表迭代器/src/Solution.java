import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2021/3/23-10:04
 */
public class Solution {
    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();

        nestedList.add(new NestedIntegerImpl(null, 1));

        List<NestedInteger> list = new ArrayList<>();
        list.add(new NestedIntegerImpl(null, 4));
        List<NestedInteger> list2 = new ArrayList<>();
        list2.add(new NestedIntegerImpl(null, 6));
        list.add(new NestedIntegerImpl(list2, null));

        nestedList.add(new NestedIntegerImpl(list, null));


//        List<NestedInteger> list = new ArrayList<>();
//        list.add(new NestedIntegerImpl(null, 1));
//        list.add(new NestedIntegerImpl(null, 1));
//        nestedList.add(new NestedIntegerImpl(list, null));
//
//        nestedList.add(new NestedIntegerImpl(null, 2));
//
//        List<NestedInteger> list2 = new ArrayList<>();
//        list2.add(new NestedIntegerImpl(null, 1));
//        list2.add(new NestedIntegerImpl(null, 1));
//        nestedList.add(new NestedIntegerImpl(list2, null));

//        List<NestedInteger> list = new ArrayList<>();
//        nestedList.add(new NestedIntegerImpl(list, null));

        NestedIterator nestedIterator = new NestedIterator(nestedList);
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }
    }
}
