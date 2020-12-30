import java.util.PriorityQueue;

/**
 * @author CuiJunJie
 * @create 2020/12/30-10:09
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (Integer x : stones) {
            queue.offer(x);
        }

        while (queue.size() > 1) {
            Integer s1 = queue.poll();
            Integer s2 = queue.poll();
            if (!s1.equals(s2)) {
                queue.offer(Math.abs(s1 - s2));
            }
        }

        if (queue.size() == 1) {
            return queue.poll();
        } else {
            return 0;
        }
    }
}
