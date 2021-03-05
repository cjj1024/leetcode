import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2021/3/4-15:53
 */
public class Solution {
    public static void main(String[] args) {
        int[][] envelopes = new int[][] {
                {5, 4}, {6, 4}, {6, 7}, {2, 3}
        };

        System.out.println(maxEnvelopes(envelopes));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length < 1) {
            return 0;
        }

        Arrays.sort(envelopes, ((o1, o2) ->
            o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]
        ));

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
