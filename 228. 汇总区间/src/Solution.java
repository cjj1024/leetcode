import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-11-04-15:24
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
//        int[] nums = {0,2,3,4,6,8,9};
        List<String> list = summaryRanges(nums);
        list.forEach(System.out::println);
    }

    public static List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }

        List<String> ret = new ArrayList<>();
        int start = 0;
        int i = 0;
        while (i < nums.length) {
            start = i;
            i++;
            while (i < nums.length && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            if (start == i - 1) {
                ret.add(String.valueOf(nums[start]));
            } else {
                ret.add(nums[start] + "->" + nums[i - 1]);
            }
        }

        return ret;
    }
}
