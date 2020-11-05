import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2020-11-04-15:36
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2, 3,3};
        List<Integer> list = majorityElement(nums);
        list.forEach(System.out::println);
    }

    public static List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }

        List<Integer> ret = new ArrayList<>();

        int candidate1 = nums[0], candidate2 = nums[0];
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 > 0 && count2 > 0) {
                count1--;
                count2--;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else {
                candidate2 = num;
                count2++;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            ret.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            ret.add(candidate2);
        }

        return ret;
    }

//    public static List<Integer> majorityElement(int[] nums) {
//        if (nums == null || nums.length < 1) {
//            return new ArrayList<>();
//        }
//
//        List<Integer> ret = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        int threshold = nums.length / 3;
//        for (int num : nums) {
//            int count = map.getOrDefault(num, 0);
//            map.put(num, count + 1);
//        }
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > threshold) {
//                ret.add(entry.getKey());
//            }
//        }
//
//        return ret;
//    }
}
