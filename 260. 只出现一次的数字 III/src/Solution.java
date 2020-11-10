import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020-11-09-15:58
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] rets = singleNumber(nums);
        for (int ret : rets) {
            System.out.println(ret);
        }
    }

    public static int[] singleNumber(int[] nums) {
        int bitMask = 0;
        for (int num : nums) {
            bitMask ^= num;
        }

        int diff = bitMask & (-bitMask);

        int x = 0;
        for (int num : nums) {
            if ((num & diff) != 0) {
                x ^= num;
            }
        }

        return new int[]{x, x ^ bitMask};
    }
}

//    public static int[] singleNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (set.contains(num)) {
//                set.remove(num);
//            } else {
//                set.add(num);
//            }
//        }
//
//        int[] ret = new int[set.size()];
//        int i = 0;
//        for (Integer num : set) {
//                ret[i++] = num;
//        }
//
//        return ret;
//    }
//}
