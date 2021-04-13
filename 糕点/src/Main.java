import java.io.*;

public class Main {
    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static int n;
    private static int m;
    private static int a;
    private static int b;
    private static int[] weights;

    private static boolean ReadInput() throws IOException {
        String line = reader.readLine();
        if (line == null || line.length() == 0) {
            return false;
        }
        String[] t = line.split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        a = Integer.parseInt(t[2]);
        b = Integer.parseInt(t[3]);

        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        weights = new int[m];
        line = reader.readLine();
        t = line.split(" ");
        for (int i = 0; i < m; i++) {
            weights[i] = Integer.parseInt(t[i]);
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));

        while (ReadInput()) {
            int minWeight = Integer.MAX_VALUE;
            int maxWeight = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                if (weights[i] > maxWeight) {
                    maxWeight = weights[i];
                }
                if (weights[i] < minWeight) {
                    minWeight = weights[i];
                }
            }

            if (minWeight < a || maxWeight > b) {
                writer.write("NO\n");
            } else {
                int remain = 0;
                if (minWeight != a) {
                    remain++;
                }
                if (maxWeight != b) {
                    remain++;
                }

                if (n - m >= remain) {
                    writer.write("YES\n");
                } else {
                    writer.write("NO\n");
                }
            }
        }

        reader.close();
        writer.close();
    }
}