import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @author CuiJunJie
 * @create 2020/12/29-9:53
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(minPatches(new int[]{1, 5, 10}, 20));
        System.out.println(minPatches(new int[]{1, 2, 2}, 5));
    }

    public static int minPatches(int[] nums, int n) {
        int index = 0;
        int num = 0;
        long x = 1;
        while (x <= n) {
            if (index < nums.length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                num++;
            }
        }

        return num;
    }

//    public static int minPatches(int[] nums, int n) {
//        BitSet set = new BitSet();
//        getAllSum(nums, n, set, 0, new BitSet());
//
//        int num = 0;
//        for (int i = 1; i <= n; i++) {
//            if (!set.get(i)) {
//                num++;
//                BitSet t = new BitSet();
//                t.set(i);
//                for (int x = set.nextSetBit(0); x >= 0; x = set.nextSetBit(x + 1)) {
//                    int sum = x + i;
//                    if (sum <= n && !set.get(sum)) {
//                        t.set(sum);
//                    }
//                }
//                for (int x = t.nextSetBit(0); x >= 0; x = t.nextSetBit(x + 1)) {
//                    set.set(x);
//                }
//            }
//        }
//
//        return num;
//    }
//
//    private static void getAllSum(int[] nums, int n, BitSet set, int k, BitSet used) {
//        if (k >= nums.length) {
//            return;
//        }
//
//
//        getAllSum(nums, n, set, k + 1, used);
//
//        if (!used.get(k)) {
//            BitSet t = new BitSet();
//            if (!set.get(nums[k])) {
//                t.set(nums[k]);
//            }
//
//            for (int x = set.nextSetBit(0); x >= 0; x = set.nextSetBit(x + 1)) {
//                int sum = x + nums[k];
//                if (sum <= n && !set.get(sum)) {
//                    t.set(sum);
//                }
//            }
//            for (int i = t.nextSetBit(0); i >= 0; i = t.nextSetBit(i + 1)) {
//                set.set(i);
//            }
//            used.set(k);
//            getAllSum(nums, n, set, k + 1, used);
//        }
//    }
}
