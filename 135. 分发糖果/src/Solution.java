import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2020-09-14-9:53
 */
public class Solution {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length < 1) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }

        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                right2left[i - 1] = right2left[i] + 1;
            }
        }

        int candyNum = 0;
        for (int i = 0; i < ratings.length; i++) {
            candyNum += Math.max(left2right[i], right2left[i]);
        }

        return candyNum;
    }
}
