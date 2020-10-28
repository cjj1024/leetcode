/**
 * @author CuiJunJie
 * @create 2020-10-27-9:57
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }

    public static int findKthLargest(int[] nums, int k) {

        MaxHeap maxHeap = new MaxHeap(nums, nums.length);
        maxHeap.init();
        for (int i = 0; i < k - 1; i++) {
            maxHeap.delete();
        }

        return maxHeap.getMax();
    }

//    public static int findKthLargest(int[] nums, int k) {
//        quickSort(nums, 0, nums.length - 1, k - 1);
//        return nums[k - 1];
//    }

    public static void quickSort(int[] nums, int i, int j, int k) {
        int left = i;
        int right = j;
        int key = nums[left];
        while (left < right) {
            while (left < right && nums[right] <= key) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
            }
            while (left < right && nums[left] >= key) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
            }
        }

        nums[left] = key;

        if (left == k) {
            return;
        } else if (left < k) {
            quickSort(nums, left + 1, j, k);
        } else {
            quickSort(nums, i, left - 1, k);
        }
    }


//    public static int findKthLargest(int[] nums, int k) {
//        for (int i = 0; i < k; i++) {
//            int t = i;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] > nums[t]) {
//                    t = j;
//                }
//            }
//            if (i != t) {
//                int tmp = nums[i];
//                nums[i] = nums[t];
//                nums[t] = tmp;
//            }
//        }
//
//        return nums[k - 1];
//    }
}
