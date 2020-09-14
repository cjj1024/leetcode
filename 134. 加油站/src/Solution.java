/**
 * @author CuiJunJie
 * @create 2020-09-11-10:23
 */
public class Solution {
    public static void main(String[] args) {
//        int[] gas  = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};
//        int[] gas  = {3, 3, 4};
//        int[] cost = {3, 4, 4};
//        int[] gas = {1,2,3,4,3,2,4,1,5,3,2,4};
//        int[] cost = {1,1,1,3,2,4,3,6,7,4,3,1};
        int[] gas = {3, 1, 1};
        int[] cost = {1, 2, 2};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        int id = -1;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                minSum = sum;
                id = i;
            }
        }

        System.out.println(sum);
        return sum >= 0 ? (id + 1) % gas.length : -1;
    }

//    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        int len = gas.length;
//        int[] pass = new int[len];
//        for (int i = 0; i < len; i++) {
//            if (gas[i] < cost[i]) {
//                pass[i] = cost[i] - gas[i];
//            } else {
//                pass[i] = -1;
//            }
//        }
//
//
//        for (int i = 0; i < len; i++) {
//            int now = i;
//            int nowGas = 0;
//            int j;
//            for (j = 0; j < len; j++) {
//                if (nowGas < pass[now]) {
//                    break;
//                }
//                nowGas = nowGas + gas[now] - cost[now];
//                now = (now + 1) % len;
//            }
//            if (j == len) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
}
