import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2020-09-26-9:55
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {8, 8, 7, 7, 7};

        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


//    public static int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//
//        int ret = nums[0];
//        int maxNum = 1;
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                int k = map.get(num) + 1;
//                if (maxNum < k) {
//                    maxNum = k;
//                    ret = num;
//                }
//                map.put(num, k);
//            } else {
//                map.put(num, 1);
//            }
//
//        }
//
//        return ret;
//    }
}
