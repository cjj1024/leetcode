/**
 * @author CuiJunJie
 * @create 2020-09-25-16:16
 */
public class Solution {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 4};
        int target = 6;

        int[] twoSum = twoSum(numbers, target);
        for (int i : twoSum) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }

        return new int[]{0, 0};
    }

//    public static int[] twoSum(int[] numbers, int target) {
//        int[] ret = new int[2];
//        for (int i = 0; i < numbers.length - 1; i++) {
//            for (int j = i + 1; j < numbers.length; j++)
//            if (numbers[i] + numbers[j] == target) {
//                ret[0] = i + 1;
//                ret[1] = j + 1;
//            }
//        }
//
//        return ret;
//    }
}
