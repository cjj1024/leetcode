import java.util.HashSet;
import java.util.Set;

/**
 * @author CuiJunJie
 * @create 2020-09-08-14:39
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLen = 0;

        for (Integer num : numSet) {
            if (!numSet.contains(num - 1)) {
                Integer cur = num;
                int len = 1;

                while (numSet.contains(cur + 1)) {
                    cur = cur + 1;
                    len = len + 1;
                }

                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}
