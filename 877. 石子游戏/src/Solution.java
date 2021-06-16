import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2021/6/16-9:42
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{5, 3, 4, 5}));
    }

    private static int[] piles;
    private static Map<String, Integer> map;
    public static boolean stoneGame(int[] piles) {
        Solution.piles = piles;
        map = new HashMap<>();

        return helper(0, piles.length - 1) > 0;
    }

    public static int helper(int i, int j) {
        if (i == j) {
            return piles[i];
        }

        String key = i + "#" + j;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int res = Math.max(piles[i] - helper(i + 1, j),
                piles[j] - helper(i, j - 1));

        map.put(key, res);

        return res;
    }
}
