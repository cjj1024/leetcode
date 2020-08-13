/**
 * @author cuijunjie
 * @create 2020--12-18:26
 */
public class Solution {
    public static void main(String[] args) {
        test(1, "123", true);
        test(2, " 123 ", true);
        test(3, "0", true);
        test(4, "0123", true);  //Cannot agree
        test(5, "00", true);  //Cannot agree
        test(6, "-10", true);
        test(7, "-0", true);
        test(8, "123.5", true);
        test(9, "123.000000", true);
        test(10, "-500.777", true);
        test(11, "0.0000001", true);
        test(12, "0.00000", true);
        test(13, "0.", true);  //Cannot be more disagree!!!
        test(14, "00.5", true);  //Strongly cannot agree
        test(15, "123e1", true);
        test(16, "1.23e10", true);
        test(17, "0.5e-10", true);
        test(18, "1.0e4.5", false);
        test(19, "0.5e04", true);
        test(20, "12 3", false);
        test(21, "1a3", false);
        test(22, "", false);
        test(23, "     ", false);
        test(24, null, false);
        test(25, ".1", true); //Ok, if you say so
        test(26, ".", false);
        test(27, "2e0", true);  //Really?!
        test(28, "+.8", true);
        test(29, " 005047e+6", true);  //Damn = =|||
    }

    public static void test(int num, String s, boolean isNum) {
        System.out.println(isNumber(s) == isNum);
    }

    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        // blank +/- 0-9 . e other
        int[][] transfer = {
                {0, 1, 2, 3, -1, -1},
                {-1, -1, 2, 3, -1, -1},
                {8, -1, 2, 5, 4, -1},
                {-1, -1, 5, -1, -1, -1},
                {-1, 6, 7, -1, -1, -1},
                {8, -1, 5, -1, 4, -1},
                {-1, -1, 7, -1, -1, -1},
                {8, -1, 7, -1, -1, -1},
                {8, -1, -1, -1, -1, -1}
        };
        int[] finals = {0, 0, 1, 0, 0, 1, 0, 1, 1};

        char[] chars = s.toCharArray();
        int state = 0;
        int id = 0;
        for (int i = 0; i < chars.length; i++) {
            id = getId(chars[i]);
            state = transfer[state][id];
            if (state == -1) {
                return false;
            }
        }
        return finals[state] == 1;
    }

    public static int getId(char c) {
        if (c >= '0' && c <= '9') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else if (c == '.') {
            return 3;
        } else if (c == 'e') {
            return 4;
        } else if (c == ' ') {
            return 0;
        } else {
            return 5;
        }
    }
}
