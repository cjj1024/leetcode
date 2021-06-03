import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2021/6/3-9:44
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 1}));
        System.out.println(findMaxLength(new int[]{0,1,0}));
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        int maxLen = 0;

        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                maxLen = Math.max(maxLen, i - map.get(counter));
            } else {
                map.put(counter, i);
            }
        }

        return maxLen;
    }

//    public static int findMaxLength(int[] nums) {
//        int n = nums.length;
//        int[] sum = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            sum[i] = sum[i - 1] + nums[i - 1];
//        }
//        int sMaxLen = Math.min(sum[n], n - sum[n]);
////        System.out.println(sMaxLen);
//
//        int maxLen = 0;
//        for (int i = 0; i <=n; i++) {
//            for (int j = i + 2; j <= n; j+=2) {
//                if (sum[j] - sum[i] > sMaxLen) {
//                    break;
//                }
//                if ((sum[j] - sum[i]) == (j - i) / 2) {
//                    maxLen = Math.max(maxLen, j - i);
//                }
//            }
//        }
//
//        return maxLen;
//    }
}
