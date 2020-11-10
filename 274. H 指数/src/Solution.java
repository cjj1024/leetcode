import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author CuiJunJie
 * @create 2020-11-10-11:17
 */
public class Solution {
    public static void main(String[] args) {
        int[] citations = {10};
        System.out.println(hIndex(citations));
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(hIndex(new int[]{0}));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);

        int len = citations.length;
        int i = 0;
        for (; i < len; ++i) {
            if (citations[i] >= len - i) {
                break;
            }
        }

        return len - i;
    }
}
