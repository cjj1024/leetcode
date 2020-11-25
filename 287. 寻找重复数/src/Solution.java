import java.util.BitSet;

/**
 * @author CuiJunJie
 * @create 2020/11/24-17:22
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(findDuplicate(new int[]{1, 1}));
    }

    public static int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int ret = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ret = mid;
            }
        }

        return ret;
    }

//    public static int findDuplicate(int[] nums) {
//        BitSet bitSet = new BitSet();
//        for (int num : nums) {
//            if (bitSet.get(num)) {
//                return num;
//            }
//            bitSet.set(num);
//        }
//
//        return -1;
//    }
}
