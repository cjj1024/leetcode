import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--03-17:55
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;

        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                continue;
            }
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) {
                    continue;
                }
                int m = len - 1;
                for (int k = j + 1; k < len - 1; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    while (m > k && nums[i] + nums[j] + nums[k] + nums[m] > target) {
                        m--;
                    }
                    if (m > k && nums[i] + nums[j] + nums[k] + nums[m] == target) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                    }
                }
            }
        }

        return ret;
    }
}
