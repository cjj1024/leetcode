import java.util.BitSet;

/**
 * @author CuiJunJie
 * @create 2020/11/24-17:22
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    public static int findDuplicate(int[] nums) {
        BitSet bitSet = new BitSet();
        for (int num : nums) {
            if (bitSet.get(num)) {
                return num;
            }
            bitSet.set(num);
        }

        return -1;
    }
}
