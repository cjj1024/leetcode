import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @create CuiJunJie
 * @date 2021/1/26-20:22
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(numEquivDominoPairs(new int[][]{
                {1, 2}, {2, 1}, {3, 4}, {5, 6}
        }));
        System.out.println(numEquivDominoPairs(new int[][]{
                {1, 1}, {1, 1}, {1, 1}, {1, 2}, {1, 2}
        }));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        String s;
        int count = 0;
        for (int[] dominoe : dominoes) {
            if (dominoe[0] < dominoe[1]) {
                s = dominoe[0] + "#" + dominoe[1];
            } else {
                s = dominoe[1] + "#" + dominoe[0];
            }
            if (map.containsKey(s)) {
                count += map.get(s);
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        return count;
    }
}
