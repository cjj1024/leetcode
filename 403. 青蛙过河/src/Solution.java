import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2021/4/29-9:17
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(canCross(new int[]{0, 2}));  // false
        System.out.println(canCross(new int[]{0,1,3,6,10,15,16,21}));  // true
        System.out.println(canCross(new int[]{0,1,3,5,6,8,12,17}));  // true
        System.out.println(canCross(new int[]{0,1,2,3,4,8,9,11}));  // false
    }

    private static Map<String, Boolean> map;
    public static boolean canCross(int[] stones) {
//        map = new HashMap<>();
//        return recursion(stones, 0, 0);

        int len = stones.length;
        boolean[][] dp = new boolean[len][len];
        dp[0][0] = true;
        for (int i = 1; i < len; i++) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
            }
        }
        for (int i = 0; i < len; i++) {
            if (dp[len - 1][i]) {
                return true;
            }
        }

        return false;
    }



//    public static boolean recursion(int[] stones, int k, int steps) {
//        String key = k + "#" + steps;
//        if (map.containsKey(key)) {
//            return map.get(key);
//        }
//        if (k == stones.length - 1) {
//            return true;
//        }
//
//        boolean flag = false;
//        for (int i = k + 1; i < stones.length; i++) {
//            if (stones[k] + steps - 1 == stones[i]) {
//                flag |= recursion(stones, i, steps - 1);
//            }
//            if (stones[k] + steps == stones[i]) {
//                flag |= recursion(stones, i, steps);
//            }
//            if (stones[k] + steps + 1 == stones[i]) {
//                flag |= recursion(stones, i, steps + 1);
//            }
//        }
//        map.put(key, flag);
//
//        return flag;
//    }
}
