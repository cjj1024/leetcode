import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2020/12/5-15:57
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] used = new boolean[nums.length];
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            for (int j = i; j < nums.length; j++) {
                while (!stack.isEmpty() && stack.peek() > )
            }
        }
    }
}
