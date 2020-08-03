import java.util.HashMap;
import java.util.Map;

/**
 * @author cuijunjie
 * @create 2020--01-16:33
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(intToRoman( 1994));
    }

    public static String intToRoman(int num) {
        int[] intArr = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strArr = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        int c;
        while (true) {
            if (num < intArr[idx]) {
                idx++;
                if (idx == intArr.length) {
                    break;
                }
            } else {
                sb.append(strArr[idx]);
                num -= intArr[idx];
            }
        }

        return sb.toString();
    }

    //        I             1
    //        V             5
    //        X             10
    //        L             50
    //        C             100
    //        D             500
    //        M             1000
//    public static String intToRoman(int num) {
//        Map<Integer, Character> roman = new HashMap<>();
//        roman.put(1, 'I');
//        roman.put(5, 'V');
//        roman.put(10, 'X');
//        roman.put(50, 'L');
//        roman.put(100, 'C');
//        roman.put(500, 'D');
//        roman.put(1000, 'M');
//
//        int[] intArr = new int[]{1000, 500, 100, 50, 10, 5, 1};
//        int idx = 0;
//        StringBuilder sb = new StringBuilder();
//        int c;
//        while (true) {
//            if (num < intArr[idx]) {
//                idx++;
//                if (idx == intArr.length) {
//                    break;
//                }
//            } else {
//                if (idx > 0) {
//                    int t = 0;
//                    while ((c = (num / intArr[t])) == 0) {
//                        t += 2;
//                    }
//                    if ((c + 1) * intArr[t] == intArr[t - 2]) {
//                        sb.append(roman.get(intArr[t]));
//                        sb.append(roman.get(intArr[t - 2]));
//                        num -= c * intArr[t];
//
//                    } else if ((c + 1) * intArr[t] == intArr[t - 1]) {
//                        sb.append(roman.get(intArr[t]));
//                        sb.append(roman.get(intArr[t - 1]));
//                        num -= c * intArr[t];
//
//                    } else {
//                        sb.append(roman.get(intArr[idx]));
//                        num -= intArr[idx];
//                    }
//                } else {
//                    sb.append(roman.get(intArr[idx]));
//                    num -= intArr[idx];
//                }
//            }
//        }
//
//        return sb.toString();
//    }
}
