import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020/11/24-17:10
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        PeekingIterator iter = new PeekingIterator(list.iterator());
        System.out.println(iter.next());
        System.out.println(iter.peek());
        System.out.println(iter.next());
        System.out.println(iter.next());
    }
}
