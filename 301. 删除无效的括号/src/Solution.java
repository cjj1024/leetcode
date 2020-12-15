import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020/12/7-15:02
 */
public class Solution {
    public static void main(String[] args) {
//        removeInvalidParentheses("()())()").forEach(System.out::println);
//        System.out.println();
//        removeInvalidParentheses("(a)())()").forEach(System.out::println);
//        System.out.println();
//        removeInvalidParentheses(")(").forEach(System.out::println);
//        System.out.println();
//        System.out.println(removeInvalidParentheses("n"));
//        System.out.println();
//        System.out.println(removeInvalidParentheses(")(f"));
        System.out.println(removeInvalidParentheses(")b))"));
        System.out.println(removeInvalidParentheses("(j))("));
    }


    public static List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() < 1) {
            list.add("");
            return list;
        }



        char[] bracket = s.toCharArray();
        boolean[] del = new boolean[bracket.length];
        if (isValid(bracket, del)) {
            list.add(s);
        } else {
            dfs(bracket, list, del, 0);
        }

        return new ArrayList<>(new HashSet<>(list));
    }

    private static void dfs(char[] bracket, List<String> list, boolean[] del, int k) {
        if (k >= bracket.length) {
            return;
        }

        boolean flag = false;
        for (int i = k; i < bracket.length; i++) {
            if (bracket[i] != ')' && bracket[i] != '(') {
                continue;
            }
            del[i] = true;
            if (isValid(bracket, del)) {
                flag = true;
                StringBuffer sb = new StringBuffer(bracket.length);
                for (int j = 0; j < bracket.length; j++) {
                    if (del[j]) {
                        continue;
                    }
                    sb.append(bracket[j]);
                }
                int num = list.isEmpty() ? 0 : list.get(0).length();
                if (num > sb.length()) {
                    return;
                } else if (num < sb.length()) {
                    list.clear();
                }
                list.add(sb.toString());
            }
            del[i] = false;
        }

        if (!flag) {
            for (int i = k; i < bracket.length; i++) {
                if (bracket[i] != ')' && bracket[i] != '(') {
                    continue;
                }
                del[i] = true;
                dfs(bracket, list, del, i + 1);
                del[i] = false;
            }
        }
    }

    private static boolean isValid(char[] bracket, boolean[] del) {
        int count = 0;
        for (int i = 0; i < bracket.length; i++) {
            if (del[i]) {
                continue;
            }
            if (bracket[i] == '(') {
                count++;
            } else if (bracket[i] == ')') {
                if (count < 1) {
                    return false;
                }
                count--;
            }
        }

        return count == 0;
    }

//    public static List<String> removeInvalidParentheses(String s) {
//        List<String> list = new ArrayList<>();
//        list.add("");
//        if (s == null || s.length() < 1) {
//            return list;
//        }
//
//        char[] bracket = s.toCharArray();
//        backtrace(bracket, list, 0, new StringBuffer(s.length()), 0);
//
//        return new ArrayList<>(new HashSet<>(list));
//    }
//
//    private static void backtrace(char[] bracket, List<String> list, int k, StringBuffer sb, int count) {
//        int num = list.get(0).length();
//        if (num > bracket.length - k + sb.length()) {
//            return;
//        }
//        if (k >= bracket.length) {
//            if (count == 0) {
//                if (sb.length() > num) {
//                    list.clear();
//                    list.add(sb.toString());
//                } else if (sb.length() == num) {
//                    list.add(sb.toString());
//                }
//            }
//        }
//
//        for (int i = k; i < bracket.length; i++) {
//            backtrace(bracket, list, i + 1, sb, count);
//
//            if (bracket[i] == '(') {
//                count++;
//            } else if (bracket[i] == ')') {
//                if (count < 1) {
//                    break;
//                } else {
//                    count--;
//                }
//            }
//            sb.append(bracket[i]);
//            backtrace(bracket, list, i + 1, sb, count);
//            sb.deleteCharAt(sb.length() - 1);
//        }
//    }
}
