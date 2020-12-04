import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020/12/4-9:42
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{1,2,3,3,4,5}));
        System.out.println(isPossible(new int[]{1,2,3,3,4,4,5,5}));
        System.out.println(isPossible(new int[]{1,2,3,4,4,5}));
    }

    public static boolean isPossible(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();
        Map<Integer, Integer> tail = new HashMap<>();

        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (numCount.get(num) == 0) {
                continue;
            }
            if (tail.getOrDefault(num - 1, 0) > 0) {
                tail.put(num - 1, tail.get(num - 1) - 1);
                tail.put(num, tail.getOrDefault(num, 0) + 1);
                numCount.put(num, numCount.get(num) - 1);
            } else if (numCount.getOrDefault(num + 1, 0) > 0 && numCount.getOrDefault(num + 2, 0) > 0){
                tail.put(num + 2, tail.getOrDefault(num + 2, 0) + 1);
                numCount.put(num, numCount.get(num) - 1);
                numCount.put(num + 1, numCount.get(num + 1) - 1);
                numCount.put(num + 2, numCount.get(num + 2) - 1);
            } else {
                return false;
            }
        }

        return true;
    }

//    public static boolean isPossible(int[] nums) {
//        if (nums == null || nums.length < 1) {
//            return false;
//        }
//
//        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
//        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                map.put(num, new PriorityQueue<>());
//            }
//            if (map.containsKey(num - 1)) {
//                Integer len = map.get(num - 1).poll();
//                map.get(num).offer(len + 1);
//                if (map.get(num - 1).size() == 0) {
//                    map.remove(num - 1);
//                }
//            } else {
//                map.get(num).offer(1);
//            }
//        }
//
//        for (PriorityQueue<Integer> queue : map.values()) {
//            for (Integer len : queue) {
//                if (len < 3) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
}
