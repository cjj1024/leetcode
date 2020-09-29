import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2020-09-29-10:20
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return "";
        }

        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrs, (s1, s2) -> -(s1 + s2).compareTo(s2 + s1));

        if ("0".equals(numStrs[0])) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : numStrs) {
            sb.append(str);
        }

        return sb.toString();
    }
}
