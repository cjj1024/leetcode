import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2021/3/23-9:31
 */
public class NestedIterator implements Iterator<Integer> {

    private Stack<List<NestedInteger>> stack = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();


    public NestedIterator(List<NestedInteger> nestedList) {
        stack.push(nestedList);
        stack2.push(0);
    }

    @Override
    public Integer next() {
        int index = stack2.peek();
        stack2.push(stack2.pop() + 1);
        return stack.peek().get(index).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && stack2.peek() >= stack.peek().size()) {
            stack.pop();
            stack2.pop();
        }

        if (stack.isEmpty()) {
            return false;
        }

        NestedInteger nestedInteger = stack.peek().get(stack2.peek());

        if (nestedInteger.isInteger()) {
            return true;
        } else {
            if (nestedInteger.getList().size() >= 1) {
                stack.push(nestedInteger.getList());
                stack2.push(stack2.pop() + 1);
                stack2.push(0);
            } else {
                stack2.push(stack2.pop() + 1);
            }

            return hasNext();
        }
    }
}
