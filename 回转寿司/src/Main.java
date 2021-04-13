import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static int T;
    private static int N;
    private static int[] A;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void ReadInput() throws IOException {
        String line = reader.readLine();
        T = Integer.parseInt(line);
    }

    private static void ReadInput2() throws IOException {
        String line = reader.readLine();
        N = Integer.parseInt(line);
        A = new int[N];
        line = reader.readLine();
        String[] t = line.split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(t[i]);
        }
    }

    /*
47823
1
13
-4318 -6757 4290 6786 6750 9653 8498 -3181 8302 6725 -169 -9725 1340

84010
1
104
-5565 -2397 6383 7800 -2058 8226 -3403 1108 1299 -7837 -798 8423 2312 7369 7391 8203 6732 -5652 7753 -5138 -6854 -3288 3813 -7681 3840 -5587 -6910 7926 9642 -4880 8618 -6054 6111 8631 600 -2757 -851 4753 -8438 5942 -4058 -4454 -4114 -6843 -3637 1202 -1565 3255 -5635 6232 8362 9899 -9 -8643 -4123 7532 545 2447 -5628 -4969 -7257 -6792 3113 -6740 -6218 -6881 -4048 5816 -4006 8283 7729 579 2421 9208 -1379 -7879 8163 4445 -9021 9980 8789 6300 7534 -7916 -4354 -7213 -7990 6286 7251 2986 7093 -5295 -5275 1870 -18 -6372 9041 -7081 4325 -7990 -1817 6152 -6925 1067

     */
    public static void main(String[] args) throws IOException {
        ReadInput();

        for (int t = 0; t < T; t++) {
            ReadInput2();

            int maxValue = A[0];
            int minValue = A[0];
            int dpMaxValue = A[0];
            int dpMinValue = A[0];

            int sum = A[0];
            for (int i = 1; i < N; i++) {
                dpMaxValue = Math.max(A[i], dpMaxValue + A[i]);
                maxValue = Math.max(maxValue, dpMaxValue);
                dpMinValue = Math.min(A[i], dpMinValue + A[i]);
                minValue = Math.min(minValue, dpMinValue);
                sum += A[i];
            }

            writer.write(String.valueOf(Math.max(maxValue, sum - minValue)));
            writer.write("\n");
        }

        writer.flush();
        reader.close();
        writer.close();
    }

//    public static void main(String[] args) throws IOException {
//        ReadInput();
//
//        for (int t = 0; t < T; t++) {
//            ReadInput2();
//            int maxValue = Integer.MIN_VALUE;
//            for (int i = 0; i < N; i++) {
//                int a = A[i];
//                maxValue = Math.max(maxValue, a);
//                for (int j = 1; j < N - 1; j++) {
//                    a += A[(i + j) % N];
//                    maxValue = Math.max(maxValue, a);
//                }
//            }
//            if (maxValue > 0) {
//                writer.write(String.valueOf(maxValue));
//            } else {
//                writer.write(String.valueOf(0));
//            }
//            writer.write("\n");
//        }
//
//        reader.close();
//        writer.close();
//    }
}