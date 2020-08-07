import java.util.BitSet;

/**
 * @author cuijunjie
 * @create 2020--07-16:32
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, -1, 2};

        System.out.println(firstMissingPositive(nums));
    }


    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int num : nums) {
            num = Math.abs(num);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; i++){
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
//    public static int firstMissingPositive(int[] nums) {
//
//        BitSet bitSet = new BitSet();
//        int maxNum = 2147483647;
//        for (int i : nums) {
//            if (i < 0) {
//                continue;
//            }
//            bitSet.set(i);
//            System.out.println(bitSet.size());
//            if (i > maxNum) {
//                maxNum = i;
//            }
//        }
//        for (int i = 1; i < maxNum; i++) {
//            if (!bitSet.get(i)) {
//                return i;
//            }
//        }
//
//        return maxNum + 1;
//    }
}
