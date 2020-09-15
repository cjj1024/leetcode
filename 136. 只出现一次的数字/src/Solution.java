import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2020-09-15-11:15
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }

        return ret;
    }

//    public static int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                map.put(num, 2);
//            } else {
//                map.put(num, 1);
//            }
//        }
//
//        for (int num : nums) {
//            if (map.get(num) == 1) {
//                return num;
//            }
//        }
//
//        return -1;
//    }
}
