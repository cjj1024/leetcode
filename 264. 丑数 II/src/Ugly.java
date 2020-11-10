/**
 * @author CuiJunJie
 * @create 2020-11-10-10:19
 */
public class Ugly {
    private int[] nums;

    public Ugly(int n) {
        nums = new int[n];

        int ugly;
        int i2 = 0, i3 = 0, i5 = 0;
        int t2, t3, t5;
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            t2 = nums[i2] * 2;
            t3 = nums[i3] * 3;
            t5 = nums[i5] * 5;
            ugly = Math.min(Math.min(t2, t3), t5);
            nums[i] = ugly;

            if (ugly == t2) {
                ++i2;
            }
            if (ugly == t3) {
                ++i3;
            }
            if (ugly == t5) {
                ++i5;
            }
        }
    }

    public int get(int i) {
        return nums[i];
    }

}
