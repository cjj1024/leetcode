import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2021/5/6-9:25
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decode(new int[]{1, 2, 3}, 1)));
        System.out.println(Arrays.toString(decode(new int[]{6, 2, 7, 3}, 4)));
    }

    public static int[] decode(int[] encoded, int first) {
        int[] decoded = new int[encoded.length + 1];
        System.arraycopy(encoded, 0, decoded, 1, encoded.length);
        decoded[0] = first;
        for (int i = 1; i < decoded.length; i++) {
            decoded[i] = decoded[i - 1] ^ encoded[i - 1];
        }

        return decoded;
    }
}
