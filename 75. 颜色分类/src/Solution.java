/**
 * @author cuijunjie
 * @create 2020--14-17:19
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int cur = 0;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                swap(nums, cur, p0);
                p0++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, p2);
                p2--;
            } else {
                cur++;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

//    public static void sortColors(int[] nums) {
//        if (nums == null || nums.length < 1) {
//            return;
//        }
//        int r = 0, g = 0, b = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0){
//                r++;
//            } else if (nums[i] == 1) {
//                g++;
//            } else {
//                b++;
//            }
//        }
//        int k = 0;
//        for (int i = 0; i < r; i++) {
//            nums[k++] = 0;
//        }
//        for (int i = 0; i < g; i++) {
//            nums[k++] = 1;
//        }
//        for (int i = 0; i < b; i++) {
//            nums[k++] = 2;
//        }
//    }
}
