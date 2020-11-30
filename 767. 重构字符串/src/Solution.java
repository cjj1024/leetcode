import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2020/11/30-11:23
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(reorganizeString("aab"));
//        System.out.println(reorganizeString("bfrbs"));
        System.out.println(reorganizeString("ogccckcwmbmxtsbmozli"));
    }

    public static String reorganizeString(String S) {
        int[] alphabet = new int[26];
        for (int i = 0; i < S.length(); i++) {
            alphabet[S.charAt(i) - 'a']++;
        }

        int maxNum = Arrays.stream(alphabet).max().getAsInt();
        if (maxNum > (S.length() + 1) / 2) {
            return "";
        }

        StringBuffer sb = new StringBuffer(S);
        int j = 0;
        while (true) {
            maxNum = alphabet[0];
            int index = 0;
            for (int k = 0; k < alphabet.length; k++) {
                if (maxNum < alphabet[k]) {
                    maxNum = alphabet[k];
                    index = k;
                }

            }
            if (maxNum == 0) {
                break;
            }
            for (int i = 0; i < maxNum; i++) {
                sb.setCharAt(j, (char) (index + 'a'));
                j += 2;
                if (j >= S.length()) {
                    j = 1;
                }
            }
            alphabet[index] = 0;
        }

        return sb.toString();
    }
}
