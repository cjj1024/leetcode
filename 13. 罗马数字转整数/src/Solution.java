import java.util.HashMap;
import java.util.Map;

/**
 * @author cuijunjie
 * @create 2020--03-10:00
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }


    //        I             1
    //        V             5
    //        X             10
    //        L             50
    //        C             100
    //        D             500
    //        M             1000
    public static int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int ret = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                ret -= roman.get(s.charAt(i));
            } else {
                ret += roman.get(s.charAt(i));
            }
        }
        ret += roman.get(s.charAt(s.length() - 1));


        return ret;
    }
}
