import java.util.Collection;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author CuiJunJie
 * @create 2021/4/1-9:21
 */
public class Solution {
    private static int index = 0;
    private static int[] op = new int[]{0, 1, 2, 3};

    public static void main(String[] args) {
        System.out.println(clumsy(10));
    }

    public static int clumsy(int N) {
        if (N == 1) {
            return 1;
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack.push(N);
        N--;
        while (N > 0) {
            if (op[index] == 0) {
                stack.push(stack.pop() * N);
            } else if (op[index] == 1) {
                stack.push(stack.pop() / N);
            } else if (op[index] == 2) {
                stack.push(N);
                stack2.push(2);
            } else {
                stack.push(N);
                stack2.push(3);
            }
            N--;
            index++;
            index = index % 4;
        }

        Collections.reverse(stack);
        Collections.reverse(stack2);
        while (!stack2.isEmpty()) {
            int num1 = stack.pop();
            int num2 = stack.pop();
            if (stack2.pop() == 2) {
                stack.push(num1 + num2);
            } else {
                stack.push(num1 - num2);
            }
        }

        return stack.pop();
    }
}