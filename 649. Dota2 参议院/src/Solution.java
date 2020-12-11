/**
 * @author CuiJunJie
 * @create 2020/12/11-9:43
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RD"));
        System.out.println(predictPartyVictory("RDD"));
    }

    public static String predictPartyVictory(String senate) {
        int r = 0;
        int d = 0;
        int count = 0;
        char[] chars = senate.toCharArray();
        while (count < chars.length) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'R') {
                    if (r >= 0) {
                        d--;
                        count++;
                    } else {
                        r++;
                        chars[i] = 'X';
                    }
                } else if (chars[i] == 'D') {
                    if (d >= 0){
                        r--;
                        count++;
                    } else {
                        d++;
                        chars[i] = 'X';
                    }
                }
            }
        }

        if (r >= 0) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }
}
