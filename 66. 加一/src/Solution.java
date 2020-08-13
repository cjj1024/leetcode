/**
 * @author cuijunjie
 * @create 2020--13-11:06
 */
public class Solution {
    public static void main(String[] args) {
        int[] digits = {9, 9};

        int[] newDigit = plusOne(digits);

        for (int digit : newDigit) {
            System.out.println(digit);
        }
    }

    public static int[] plusOne(int[] digits) {
        int carry = 0;
        int sum = 0;
        sum = digits[digits.length - 1] + 1;
        digits[digits.length - 1] = sum % 10;
        carry = sum / 10;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (carry == 0) {
                break;
            }
            sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        if (carry > 0) {
            int[] newDigit = new int[digits.length + 1];
            newDigit[0] = carry;
            return newDigit;
        }

        return digits;
    }
}
