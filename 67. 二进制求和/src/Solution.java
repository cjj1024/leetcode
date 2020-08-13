/**
 * @author cuijunjie
 * @create 2020--13-11:18
 */
public class Solution {
    public static void main(String[] args) {
        String a = "1";
        String b = "111";
        String sum = addBinary(a, b);
        System.out.println(sum);
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder(Math.max(a.length(), b.length()));

        int[] aInt = new int[a.length()];
        int[] bInt = new int[b.length()];
        for (int k = 0; k < a.length(); k++) {
            aInt[k] = a.charAt(k) - '0';
        }
        for (int k = 0; k < b.length(); k++) {
            bInt[k] = b.charAt(k) - '0';
        }

        int c1 = 0;
        int c2 = 0;
        int carry = 0;
        int sum = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        for (; i >= 0 && j >= 0; --i, --j) {
            sum = aInt[i] + bInt[j] + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        for (; i >= 0; --i) {
            sum = aInt[i] + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        for (; j >= 0; --j) {
            sum = bInt[j] + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry > 0) {
            sb.append(carry);
        }
        sb.reverse();

        return sb.toString();
    }
}
