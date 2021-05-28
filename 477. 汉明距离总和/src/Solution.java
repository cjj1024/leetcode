/**
 * @author CuiJunJie
 * @create 2021/5/28-9:38
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(totalHammingDistance(new int[]{4, 14, 2}));
    }

    public static int totalHammingDistance(int[] nums) {
        int totalDist = 0;
        boolean flag = true;
        while (flag) {
            int dist = 0;
            for (int i = 0; i < nums.length; i++) {
                dist += nums[i] % 2;
            }
            totalDist += dist * (nums.length - dist);

            flag = false;
            for (int i = 0; i < nums.length; i++) {
                nums[i] /= 2;
                if (nums[i] != 0) {
                    flag = true;
                }
            }
        }

        return totalDist;
    }
}
