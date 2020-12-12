import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020/12/7-15:02
 */
public class Solution {
    public static void main(String[] args) {
        removeInvalidParentheses("()())()").forEach(System.out::println);
    }

    public static List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() < 1) {
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();

        return list;
    }
}
