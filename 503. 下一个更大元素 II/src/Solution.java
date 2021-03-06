import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2021/3/6-9:34
 */
public class Solution {
    public static void main(String[] args) {
        int[] nextNum = nextGreaterElements(new int[]{1, 2, 1});
        for (int num : nextNum) {
            System.out.println(num);
        }
    }

    public static int[] nextGreaterElements(int[] nums) {
        if (nums.length < 1) {
            return new int[]{};
        }

        int[] nextNum = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            nextNum[i] = nums[i];
        }
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        stack.push(i);
        for (int k = 0; k < nums.length * 2; k++) {
            i++;
            i %= nums.length;
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                nextNum[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        for (i = 0; i < nums.length; i++){
            if (nextNum[i] == nums[i]) {
                nextNum[i] = -1;
            }
        }

        return nextNum;
    }

//    public static int[] nextGreaterElements(int[] nums) {
//        if (nums.length < 1) {
//            return new int[]{};
//        }
//
//        int[] nextNum = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            nextNum[i] = nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int j = i + 1;
//            j %= nums.length;
//            for (int k = 0; k < nums.length; k++) {
//                if (nums[j] > nums[i]) {
//                    nextNum[i] = nums[j];
//                    break;
//                }
//                j++;
//                j %= nums.length;
//            }
//            if (nums[i] == nextNum[i]) {
//                nextNum[i] = -1;
//            }
//        }
//
//        return nextNum;
//    }
}
