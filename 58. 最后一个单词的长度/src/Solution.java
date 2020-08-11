/**
 * @author cuijunjie
 * @create 2020--11-16:28
 */
public class Solution {
    public static void main(String[] args) {
        String s = "a ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }


        int ret = 0;
        for (; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                ret++;
            } else {
                break;
            }
        }

        return ret;
    }
}
