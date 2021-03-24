import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2021/3/24-10:06
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(find132pattern(new int[]{-1, 3, 2, 0}));
        System.out.println(find132pattern(new int[]{1, 0, 1, -4, -3}));
    }

    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(nums[nums.length - 1]);
        int max2 = Integer.MIN_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < max2) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                max2 = stack.pop();
            }
            if (nums[i] > max2) {
                stack.push(nums[i]);
            }
        }

        return false;
    }

//    public static boolean find132pattern(int[] nums) {
//        if (nums.length < 3) {
//            return false;
//        }
//
//        int[] pattern = new int[3];
//        int index = 0;
//        for (int j = 0; j < nums.length; j++) {
//            pattern[0] = nums[j];
//            for (int i = j + 1; i < nums.length; i++) {
//                if (index == 0 && nums[i] > pattern[0]) {
//                    index++;
//                    pattern[1] = nums[i];
//                }
//                if (index == 1 && nums[i] > pattern[1]) {
//                    pattern[1] = nums[i];
//                }
//                if (index == 1 && nums[i] < pattern[1] && nums[i] > pattern[0]) {
//                    return true;
//                }
//            }
//            index = 0;
//        }
//
//        return false;
//    }
}
