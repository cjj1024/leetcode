import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] a = new int[5];
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;
        a[3] = 3;
        a[4] = 5;
        int b = 5;
        int[] res = twoSum(a, b);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int i = 0;
        int k = 0;
        for (i = 0; i < nums.length; i++) {
            k = target - nums[i];
            if (m.get(k) != null) {
                res[0] = i;
                res[1] = m.get(k);
                return res;
            }
            m.put(nums[i], i);
        }
        return res;
    }
}
