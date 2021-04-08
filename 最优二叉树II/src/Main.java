/**
 * @author CuiJunJie
 * @create 2021/4/2-16:23
 */
import java.io.*;
import java.util.Arrays;

class Node {
    public int value;
    public Node leftNode;
    public Node rightNode;
}

public class Main {
    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static int N;
    private static int[] values;
    private static int minValue = Integer.MAX_VALUE;
    private static Node root;
    private static int[][][] dp;


    public static void readInput() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(reader.readLine());
        values = new int[N + 1];
        int i = 1;
        for (String s : reader.readLine().split(" ")) {
            values[i++] = Integer.parseInt(s);
        }
        dp = new int[N + 1][N + 1][N + 1];
        for (i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                for (int k = 0; k < N + 1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        readInput();

        int minValue = recursion(1, N, 0);

        writer.write(String.valueOf(minValue));
        writer.flush();
    }

    private static int recursion(int left, int right, int parent) {
        if (left > right) {
            return 0;
        }
        if (dp[left][right][parent] != -1) {
            return dp[left][right][parent];
        }

        int minValue = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            int leftValue = recursion(left, i - 1, i);
            int rightValue = recursion(i + 1, right, i);
            minValue = Math.min(minValue, leftValue + rightValue + values[i] * values[parent]);
        }

        dp[left][right][parent] = minValue;

        return minValue;
    }
}