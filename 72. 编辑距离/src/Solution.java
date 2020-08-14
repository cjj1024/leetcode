/**
 * @author cuijunjie
 * @create 2020--14-10:41
 */
public class Solution {
    public static void main(String[] args) {

        String word1 = "intention", word2 = "execution";
        System.out.println(minDistance(word1, word2));

    }

    public static int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null || word1.length() < 1) {
            return word2.length();
        }
        if (word2 == null || word2.length() < 1) {
            return word1.length();
        }

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int len1 = w1.length;
        int len2 = w2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (w1[i] == w2[j]) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                }
            }
        }

        return dp[len1][len2];
    }
}
