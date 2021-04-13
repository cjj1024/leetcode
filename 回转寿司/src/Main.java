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

     */
    public static void main(String[] args) throws IOException {
        ReadInput();

        for (int t = 0; t < T; t++) {
            ReadInput2();

            int maxValue = Integer.MIN_VALUE;
            int left = 0;
            int right = 0;
            int a = A[0];
            maxValue = Math.max(maxValue, a);
            while (true) {
                right++;
                if (right == 2 * N) {
                    break;
                }
                if (right - left + 1 == N) {
                    a -= A[left % N];
                    left++;
                    while (left < right && A[left % N] < 0) {
                        a -= A[left % N];
                        left++;
                    }
                }
                maxValue = Math.max(maxValue, a);
                a += A[right % N];
                maxValue = Math.max(maxValue, a);
            }

            maxValue = Math.max(maxValue, 0);
            writer.write(String.valueOf(maxValue));
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