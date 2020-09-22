import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author CuiJunJie
 * @create 2020-09-22-9:49
 */
public class Solution {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        String[] strs = s.split(" +");
        Collections.reverse(Arrays.asList(strs));
        return String.join(" ", strs);
    }
}
