import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cuijunjie
 * @create 2020--03-16:38
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static Map<String, String> num2Letter = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    public static List<String> ret = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack(new StringBuilder(), digits);
        }

        return ret;
    }

    public static void backtrack(StringBuilder combination, String digits) {
        if (digits.length() == 0) {
            ret.add(combination.toString());
            return;
        }

        String letter = num2Letter.get(digits.substring(0, 1));
        for (char c : letter.toCharArray()) {
            combination.append(c);
            backtrack(combination, digits.substring(1));
            combination.deleteCharAt(combination.length() - 1);
        }

    }
}
