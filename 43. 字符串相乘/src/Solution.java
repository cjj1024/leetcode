import javax.management.StringValueExp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--08-11:26
 */
public class Solution {
    public static void main(String[] args) {
        String num1 = "9999";
        String num2 = "9999";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) {
            return "0";
        }
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] num1Array = new int[num1.length()];
        int[] num2Array = new int[num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            num1Array[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < num2.length(); i++) {
            num2Array[i] = num2.charAt(i) - '0';
        }

        int[] ret = new int[num1Array.length + num2Array.length];
        int sum = 0;
        for (int i = num1Array.length - 1; i >= 0; i--) {
            for (int j = num2Array.length - 1; j >= 0; j--) {
                sum = ret[i + j + 1] + num1Array[i] * num2Array[j];
                ret[i + j + 1] = sum % 10;
                ret[i + j] += sum / 10;
            }
        }

        StringBuilder ret2 = new StringBuilder(ret.length);
        int i = 0;
        while (ret[i] == 0) {
            i++;
        }
        for (; i < ret.length; i++) {

            ret2.append(ret[i]);
        }

        return ret2.toString();
    }

//    public static String multiply(String num1, String num2) {
//        if (num1.length() == 0 || num2.length() == 0) {
//            return "0";
//        }
//        if ("0".equals(num1) || "0".equals(num2)) {
//            return "0";
//        }
//
//        int[] num1Array = new int[num1.length()];
//        int[] num2Array = new int[num2.length()];
//        for (int i = 0; i < num1.length(); i++) {
//            num1Array[i] = num1.charAt(i) - '0';
//        }
//        for (int i = 0; i < num2.length(); i++) {
//            num2Array[i] = num2.charAt(i) - '0';
//        }
//        List<Integer> list = new ArrayList<>(Math.max(num1Array.length, num2Array.length));
//        ArrayList<Integer> list2 = new ArrayList<>(Math.max(num1Array.length, num2Array.length));
//        List<Integer> ret = new ArrayList<>(Math.max(num1Array.length, num2Array.length));
//        int carry = 0;
//        int tmp = 0;
//        for (int i = num1Array.length - 1; i >= 0; i--) {
//            carry = 0;
//            list.clear();
//            list2.clear();
//            for (int j = num2Array.length - 1; j >= 0; j--) {
//                tmp = num1Array[i] * num2Array[j] + carry;
//                carry = tmp / 10;
//                tmp %= 10;
//                list.add(tmp);
//            }
//            if (carry > 0) {
//                list.add(carry);
//            }
//            Collections.reverse(list);
//            int k = i;
//            while (k < num1Array.length - 1) {
//                list.add(0);
//                k++;
//            }
//
//            int diff = list.size() - list2.size();
//            for (int j = 0; j < diff; j++) {
//                list2.add(0);
//            }
//            diff = list2.size() - ret.size();
//            for (int j = 0; j < diff; j++) {
//                ret.add(0, 0);
//            }
//            carry = 0;
//            for (int j = list.size() - 1; j >= 0; j--) {
//                tmp = list.get(j) + ret.get(j) + carry;
//                carry = tmp / 10;
//                tmp %= 10;
//                list2.set(j, tmp);
//            }
//            if (carry > 0) {
//                list2.add(0, carry);
//            }
//            diff = list2.size() - ret.size();
//            for (int j = 0; j < diff; j++) {
//                ret.add(0);
//            }
//            for (int j = 0; j < list2.size(); j++) {
//                ret.set(j, list2.get(j));
//            }
//        }
//
//        StringBuilder ret2 = new StringBuilder(ret.size());
//        for (int i = 0; i < ret.size(); i++) {
//            ret2.append(ret.get(i));
//        }
//        return ret2.toString();
//    }
}
