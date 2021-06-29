/**
 * @author CuiJunJie
 * @create 2020-09-25-16:30
 */
public class Solution {
    public static void main(String[] args) {
        int n = 701;        // ZY
        System.out.println(convertToTitle(n));
        System.out.println(convertToTitle(2147483647));         // FXSHRXW
    }

    private static char[] number = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            int x = columnNumber % 26;
            sb.append(number[x]);
            columnNumber = columnNumber / 26;
        }

        return sb.reverse().toString();
    }

//    public static String convertToTitle(int n) {
//        if (n < 1) {
//            return "";
//        }
//
//        StringBuilder ret = new StringBuilder();
//        while (n != 0) {
//            n--;
//            int num = n % 26;
//            ret.append((char) (num + 'A'));
//            n = n / 26;
//
//        }
//
//        return ret.reverse().toString();
//    }
}
