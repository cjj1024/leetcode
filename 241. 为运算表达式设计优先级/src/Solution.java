import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author CuiJunJie
 * @create 2020-11-07-11:19
 */
public class Solution {
    public static void main(String[] args) {
        String input = "2*3-4*5";
        List<Integer> ret = diffWaysToCompute(input);
        for (Integer integer : ret) {
            System.out.println(integer);
        }
    }

    public static List<Integer> diffWaysToCompute(String input) {

        List<Integer> ret = new ArrayList<>();

        boolean flag = true;
        for (int i = 0; i < input.length(); i++) {
            if (isOperation(input.charAt(i))) {
                flag = false;
                List<Integer> ret1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> ret2 = diffWaysToCompute(input.substring(i + 1));

                for (Integer a : ret1) {
                    for (Integer b : ret2) {
                        ret.add(calc(a, input.charAt(i), b));
                    }
                }
            }
        }
        if (flag) {
            ret.add(Integer.parseInt(input));
        }

        return ret;
    }

    private static boolean isOperation(char c) {
        if (c == '+' || c == '-' || c == '*') {
            return true;
        }

        return false;
    }

    private static Integer calc(Integer a, char op, Integer b) {
        if ('+' == op) {
            return a + b;
        } else if ('-' == op) {
            return a - b;
        } else if ('*' == op) {
            return a * b;
        }

        return 0;
    }
}
