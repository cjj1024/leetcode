import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020-11-06-16:36
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
//        int[] nums = {1};
        int[] maxSlidingWindow = maxSlidingWindow(nums, 5);
        for (int i : maxSlidingWindow) {
            System.out.println(i);
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= k) {
            return new int[]{Arrays.stream(nums).max().getAsInt()};
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> nums[o2] - nums[o1]));
        for (int i = 0; i < k; i++) {
            queue.offer(i);
        }

        int[] maxNum = new int[nums.length - k + 1];
        int j = 0;
        maxNum[j++] = nums[queue.peek()];
        for (int i = k; i < nums.length; i++) {
            queue.offer(i);
            while (!queue.isEmpty() && queue.peek() <= i - k) {
                queue.poll();
            }
            maxNum[j++] = nums[queue.peek()];
        }

        return maxNum;
    }

//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length <= k) {
//            return new int[]{Arrays.stream(nums).max().getAsInt()};
//        }
//
//        int[] maxNum = new int[nums.length - k + 1];
//        int[] helper = new int[k];
//        Arrays.fill(helper, Integer.MIN_VALUE);
//        for (int i = 0; i < k; i++) {
//            for (int j = 0; j <= i; j++) {
//                helper[j] = Math.max(helper[j], nums[i]);
//            }
//        }
//        int i = 0;
//        int index = 0;
//        for (int j = k; j < nums.length; j++) {
//            maxNum[i++] = helper[index];
//            helper[index] = Integer.MIN_VALUE;
//            index++;
//            index = index % k;
//            for (int m = 0; m < k; m++) {
//                helper[m] = Math.max(helper[m], nums[j]);
//            }
//        }
//        maxNum[i++] = helper[index];
//
//        return maxNum;
//    }

//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length <= k) {
//            return new int[]{Arrays.stream(nums).max().getAsInt()};
//        }
//        if (k == 1) {
//            return nums;
//        }
//
//        Deque<Integer> deque = new ArrayDeque<>();
//        for (int i = 0; i < k; i++) {
//            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
//                deque.removeLast();
//            }
//            deque.addLast(i);
//        }
//
//        int[] ret = new int[nums.length - k + 1];
//        ret[0] = nums[deque.getFirst()];
//        for (int i = k; i < nums.length; i++) {
//            if (deque.getFirst() == i - k) {
//                deque.removeFirst();
//            }
//            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
//                deque.removeLast();
//            }
//            deque.addLast(i);
//            ret[i - k + 1] = nums[deque.getFirst()];
//        }
//
//        return ret;
//    }
}


//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length <= k) {
//            return new int[]{Arrays.stream(nums).max().getAsInt()};
//        }
//        if (k == 1) {
//            return nums;
//        }
//
//        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
//        int[] ret = new int[nums.length - k + 1];
//        for (int i = 0; i < k; i++) {
//            queue.add(nums[i]);
//        }
//        ret[0] = queue.peek();
//        for (int i = k; i < nums.length; i++) {
//            queue.remove(nums[i - k]);
//            queue.add(nums[i]);
//            ret[i - k + 1] = queue.peek();
//        }
//
//        return ret;
//    }
//}
