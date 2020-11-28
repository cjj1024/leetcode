import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2020/11/28-9:26
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{2, 4, 3, 5, 1}));
        System.out.println(reversePairs(new int[]{5, 4, 3, 2, 1}));
    }

    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return 0;
        }

        int mid = (start + end) >> 1;
        int num1 = mergeSort(nums, start, mid);
        int num2 = mergeSort(nums, mid + 1, end);
        int num = num1 + num2;

        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (((nums[i] + 1) >> 1) > nums[j]) {
                num += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }

        int[] tmp = new int[end - start + 1];
        i = start;
        j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= end) {
            tmp[k++] = nums[j++];
        }
        System.arraycopy(tmp, 0, nums, start, end - start + 1);

        return num;
    }


//    public static int reversePairs(int[] nums) {
//        if (nums == null || nums.length < 2) {
//            return 0;
//        }
//
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (((nums[i] + 1) >> 1) > nums[j]) {
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }
}
