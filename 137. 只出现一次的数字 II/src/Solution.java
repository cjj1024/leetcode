/**
 * @author CuiJunJie
 * @create 2020-09-15-11:21
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int once = 0;
        int twice = 0;

        for (int num : nums) {
            once = (once ^ num) & (~twice);
            twice = (twice ^ num) & (~once);
        }


        return once;
    }
}
