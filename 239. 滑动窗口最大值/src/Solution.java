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
        if (k == 1) {
            return nums;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        int[] ret = new int[nums.length - k + 1];
        ret[0] = nums[deque.getFirst()];
        for (int i = k; i < nums.length; i++) {
            if (deque.getFirst() == i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            ret[i - k + 1] = nums[deque.getFirst()];
        }

        return ret;
    }
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
