/**
 * @author CuiJunJie
 * @create 2020-10-10-10:12
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 2;

        rotate(nums, k);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void rotate(int[] nums, int k) {
        if (nums == null) {
            return;
        }

        int next;
        int t1;
        int t2;
        int n = nums.length;
        int i = 0;
        int start = 0;
        while (i < n) {
            int index = start;
            int current = start;
            t1 = nums[current];
            do {
                next = (current + k) % n;
                t2 = nums[next];
                nums[next] = t1;
                t1 = t2;
                current = next;
                i++;
            } while (index != next);
            start++;
        }
    }
}
