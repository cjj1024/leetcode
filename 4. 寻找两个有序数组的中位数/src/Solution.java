public class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }


    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = 0, n = 0;
        int i = 0, j = 0;
        int idx = (int)Math.floor((nums1.length + nums2.length) / (float)2) + 1;
        int num = 0;
        int med1 = 0, med2 = 0;

        while (num < idx && i < nums1.length && j < nums2.length) {
            med2 = med1;
            ++num;
            if (nums1[i] < nums2[j]) {
                med1 = nums1[i];
                ++i;
            } else {
                med1 = nums2[j];
                ++j;
            }
        }

        while (num < idx && i < nums1.length) {
            med2 = med1;
            ++num;
            med1 = nums1[i];
            ++i;
        }

        while (num < idx && j < nums2.length) {
            med2 = med1;
            ++num;
            med1 = nums2[j];
            ++j;
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (med1 + med2) / (float)2;
        } else {
            return med1;
        }
    }
}