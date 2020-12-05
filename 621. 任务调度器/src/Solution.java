import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author CuiJunJie
 * @create 2020/12/5-9:46
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)); //8
//        System.out.println(leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2)); //16
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'}, 2)); //12
    }

    public static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length < 1) {
            return 0;
        }
        if (n == 0) {
            return tasks.length;
        }

        Map<Character, Integer> taskNum = new HashMap<>();
        Map<Character, Integer> cooldown = new HashMap<>();

        for (Character task : tasks) {
            taskNum.put(task, taskNum.getOrDefault(task, 0) + 1);
        }
        for (Character task : taskNum.keySet()) {
            cooldown.put(task, 0);
        }

        int time = 0;
        while (!taskNum.isEmpty()) {
            Character task = getMin(cooldown, taskNum);
            if (cooldown.get(task) > 0) {
                ++time;
                for (Character t : cooldown.keySet()) {
                    cooldown.put(t, cooldown.get(t) - 1);
                }
            } else {
                ++time;
                for (Character t : cooldown.keySet()) {
                    cooldown.put(t, Math.max(cooldown.get(t) - 1, 0));
                }
                cooldown.put(task, n);
                if (taskNum.get(task) == 1) {
                    taskNum.remove(task);
                    cooldown.remove(task);
                } else {
                    taskNum.put(task, taskNum.get(task) - 1);
                }
            }
        }

        return time;
    }

    private static Character getMin(Map<Character, Integer> cooldown, Map<Character, Integer> taskNum) {
        int minTime = Integer.MAX_VALUE;
        Character minTask = null;
        for (Character task : cooldown.keySet()) {
            if (cooldown.get(task) < minTime) {
                minTime = cooldown.get(task);
                minTask = task;
            } else if (cooldown.get(task) == minTime) {
                if (taskNum.get(task) > taskNum.get(minTask)) {
                    minTime = cooldown.get(task);
                    minTask = task;
                }
            }
        }

        return minTask;
    }
}
