import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author CuiJunJie
 * @create 2020/12/2-9:34
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5);
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println();
        nums = maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5);
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println();
        nums = maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3);
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println();
        nums = maxNumber(new int[]{2,5,6,4,4,0}, new int[]{7,3,8,0,6,5,7,6,2}, 15);
        Arrays.stream(nums).forEach(System.out::println);
    }


    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        Integer[] nums = new Integer[k];
        Arrays.fill(nums, 0);
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(nums1.length, k); i++) {
            Integer[] sub1 = getSubSeq(nums1, i);
            Integer[] sub2 = getSubSeq(nums2, k - i);
            Integer[] t = merge(sub1, sub2);
            if (compare(t, nums, k)) {
                System.arraycopy(t, 0, nums, 0, k);
            }
        }

        return Arrays.stream(nums).mapToInt(i -> (int) i).toArray();
    }

    private static Integer[] merge(Integer[] sub1, Integer[] sub2) {
        if (sub1.length < 1) {
            return sub2;
        }
        if (sub2.length < 1) {
            return sub1;
        }

        Integer[] nums = new Integer[sub1.length + sub2.length];
        int i = 0, j = 0, k = 0;
        while (i < sub1.length && j < sub2.length) {
            if (compare(sub1, i, sub2, j)) {
                nums[k++] = sub1[i++];
            } else {
                nums[k++] = sub2[j++];
            }
        }
        while (i < sub1.length) {
            nums[k++] = sub1[i++];
        }
        while (j < sub2.length) {
            nums[k++] = sub2[j++];
        }

        return nums;
    }

    private static boolean compare(Integer[] sub1, int i, Integer[] sub2, int j) {
        for (; i < sub1.length && j < sub2.length; ) {
            if (sub1[i] > sub2[j]) {
                return true;
            } else if (sub1[i] < sub2[j]) {
                return false;
            } else {
                i++;
                j++;
            }
        }

        return i != sub1.length;
    }

    private static Integer[] getSubSeq(int[] nums2, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>(k);
        int remain = nums2.length - k;
        for (int i = 0; i < nums2.length; i++) {
            while (!deque.isEmpty() && nums2[i] > deque.peekLast() && remain > 0) {
                deque.removeLast();
                remain--;
            }

            if (deque.size() < k) {
                deque.addLast(nums2[i]);
            } else {
                remain--;
            }
        }
        return deque.toArray(new Integer[]{});
    }

    private static boolean compare(Integer[] nums1, Integer[] nums2, int k) {
        int i = 0;
        while (i < k) {
            if (nums1[i] > nums2[i]) {
                return true;
            } else if (nums1[i] < nums2[i]) {
                return false;
            }
            i++;
        }

        return false;
    }

    //    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        int[] nums = new int[k];
//        Arrays.fill(nums, 0);
//        backtrace(nums1, nums2, k, nums, new int[k], 0, 0, 0);
//
//        return nums;
//    }
//
//    private static void backtrace(int[] nums1, int[] nums2, int k, int[] nums, int[] t, int s1, int s2, int s3) {
//        if (s3 == k) {
//            if (!compare(nums, t, k)) {
//                System.arraycopy(t, 0, nums, 0, t.length);
//            }
//            return;
//        }
//
//        if (compare(nums, t, s3)) {
//            return;
//        }
//        for (int i = s1; i < nums1.length; i++) {
//            t[s3] = nums1[i];
//            backtrace(nums1, nums2, k, nums, t, i + 1, s2, s3 + 1);
//        }
//        for (int j = s2; j < nums2.length; j++) {
//            t[s3] = nums2[j];
//            backtrace(nums1, nums2, k, nums, t, s1, j + 1, s3 + 1);
//        }
//    }
//
//    private static boolean compare(int[] nums1, int[] nums2, int k) {
//        int i = 0;
//        while (i < k) {
//            if (nums1[i] > nums2[i]) {
//                return true;
//            } else if (nums1[i] < nums2[i]) {
//                return false;
//            }
//            i++;
//        }
//
//        return false;
//    }
}
