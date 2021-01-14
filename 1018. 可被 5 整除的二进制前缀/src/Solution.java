import java.util.ArrayList;
import java.util.List;

/**
 * @create CuiJunJie
 * @date 2021/1/14-16:51
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1}));
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        int num = 0;
        List<Boolean> ret = new ArrayList<>(A.length);
        for (int i = 0; i < A.length; i++) {
            num = num * 2 + A[i];
            if (num % 5 == 0) {
                ret.add(true);
            } else {
                ret.add(false);
            }
            num = num % 10;
        }

        return ret;
    }
}
