/**
 * @author cuijunjie
 * @create 2020--19-14:12
 */
public class Solution {
    public static void main(String[] args) {
        String s = "17";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        char[] sChar = s.toCharArray();

        int pre = 1, cur = 1, tmp;
        if (sChar[0] == '0') {
            return 0;
        }
        for (int i = 1; i < sChar.length; i++) {
            tmp = cur;
            if (sChar[i] == '0') {
                if (sChar[i - 1] == '1' || sChar[i - 1] == '2') {
                    cur = pre;
                } else {
                    return 0;
                }
            } else if (sChar[i - 1] == '1' || (sChar[i - 1] == '2' && (sChar[i] >= '1' && sChar[i] <= '6'))){
                cur = cur + pre;
            }
            pre = tmp;
        }
        return cur;
    }
}
