import java.io.*;
import java.util.Scanner;

/**
 * @author CuiJunJie
 * @create 2021/8/23-19:57
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();

        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= N; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i - 1][j - 1];
            }
        }

        System.out.println(dp[M][N]);
    }
}

/*

3 3
1 3 1
1 5 1
4 2 1

7
 */

/*
2 3
1 2 3
4 5 6

12
 */

/*
3 3
1 3 1
1 5 1
4 2 1

7

 */