import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2020-11-10-10:34
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(numberToWords(1));
        System.out.println(numberToWords(12));
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(1234));
        System.out.println(numberToWords(12345));
        System.out.println(numberToWords(123456));
        System.out.println(numberToWords(1234567));
        System.out.println(numberToWords(12345678));
        System.out.println(numberToWords(123456789));
        System.out.println(numberToWords(1234567890));
    }


    private final static String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
    "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final static String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final static int BILLION = 1000000000;
    private final static int MILLION = 1000000;
    private final static int THOUSAND = 1000;
    private final static int HUNDRED = 100;

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder sb = new StringBuilder();
        helper(num, sb);
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private static void helper(int num, StringBuilder sb) {
        if (num >= BILLION) {
            helper(num / BILLION, sb);
            sb.append("Billion ");
            helper(num - num / BILLION * BILLION, sb);
        } else if (num >= MILLION) {
            helper(num / MILLION, sb);
            sb.append("Million ");
            helper(num - num / MILLION * MILLION, sb);
        } else if (num >= THOUSAND) {
            helper(num / THOUSAND, sb);
            sb.append("Thousand ");
            helper(num - num / THOUSAND * THOUSAND, sb);
        } else if (num >= HUNDRED) {
            helper(num / HUNDRED, sb);
            sb.append("Hundred ");
            helper(num - num / HUNDRED * HUNDRED, sb);
        } else if (num >= 20) {
            sb.append(TENS[num / 10]);
            sb.append(" ");
            helper(num - num / 10 * 10, sb);
        } else if (num > 0){
            sb.append(LESS_THAN_TWENTY[num]);
            sb.append(" ");
        }
    }
}
