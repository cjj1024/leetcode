import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author CuiJunJie
 * @create 2021/7/7-9:46
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{1,3,5,7,9}));       // 4
        System.out.println(countPairs(new int[]{1,1,1,3,3,3,7}));     //  15
        System.out.println(countPairs(new int[]{149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234}));   // 12
    }

    private static int MOD = 1000000000 + 7;
    public static int countPairs(int[] deliciousness) {
        Set<Long> set = new HashSet<>();
        long base = 2;
        set.add(1L);
        for (int i = 1; i <= 21; i++) {
            set.add(base);
            base = base * 2;
        }

        Map<Long, Integer> map = new HashMap<>();
        for (long i : deliciousness) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int count = 0;
        for (long i : deliciousness) {
            if (map.get(i) == 1) {
                map.remove(i);
            } else {
                map.put(i, map.get(i) - 1);
            }
            for (Long x : set) {
                if (map.containsKey(x - i)) {
                    count = count + map.get(x - i);
                    count = count % MOD;
                }
            }
        }

        return count;
    }
}
