import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2021/4/26-9:24
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    public static int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        int mid;
        while (left < right) {
            mid = (right - left) / 2 + left;
            int days = getDays(weights, mid);
            if (days > D) {
                left = mid + 1;
            } else if (days <= D) {
                right = mid;
            }
        }

        return left;
    }

//    public static int shipWithinDays(int[] weights, int D) {
//        double sumWeight = Arrays.stream(weights).sum();
//        int maxWeight = Arrays.stream(weights).max().getAsInt();
//
//        int weight = Math.max((int) Math.ceil(sumWeight / D), maxWeight);
//
//        while (true) {
//            if (getDays(weights, weight) > D) {
//                weight++;
//            } else {
//                break;
//            }
//        }
//
//        return weight;
//    }

    private static int getDays(int[] weights, int weight) {
        int days = 1;
        int sum = 0;
        for (int i = 0; i< weights.length; i++) {
            sum += weights[i];
            if (sum > weight) {
                days++;
                sum = weights[i];
            }
        }

        return days;
    }
}
