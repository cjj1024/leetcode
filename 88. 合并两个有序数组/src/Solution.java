import java.util.Arrays;

/**
 * @author cuijunjie
 * @create 2020--18-16:44
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, nums2.length);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, 0, nums1, nums1.length - m, m);
        int i = nums1.length - m;
        int j = 0;
        int k = 0;
        while (i < m + n && j < n) {
            if (nums1[i] < nums2[j]) {
                nums1[k++] = nums1[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        while (i < m + n) {
            nums1[k++] = nums1[i++];
        }
        while (j < n) {
            nums1[k++] = nums2[j++];
        }
    }




//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int i = m - 1, j = n - 1;
//        int k = nums1.length - 1;
//        while (i >= 0 && j >= 0) {
//            if (nums1[i] > nums2[j]) {
//                nums1[k--] = nums1[i--];
//            } else {
//                nums1[k--] = nums2[j--];
//            }
//        }
//        while (i >= 0) {
//            nums1[k--] = nums1[i--];
//        }
//        while (j >= 0) {
//            nums1[k--] = nums2[j--];
//        }
//    }


//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] nums = Arrays.copyOf(nums1, m);
//        int k = 0;
//        int i = 0, j = 0;
//        while (i < m && j < n) {
//            if (nums[i] < nums2[j]) {
//                nums1[k++] = nums[i++];
//            } else {
//                nums1[k++] = nums2[j++];
//            }
//        }
//        while (i < m) {
//            nums1[k++] = nums[i++];
//        }
//        while (j < n) {
//            nums1[k++] = nums2[j++];
//        }
//    }
}
