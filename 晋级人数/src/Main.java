import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static int n;
    private static int x;
    private static int[] scores;

    private static void ReadInput() throws IOException{
        String line = reader.readLine();
        String[] t = line.split(" ");
        n = Integer.parseInt(t[0]);
        x = Integer.parseInt(t[1]);

        scores = new int[n];
        line = reader.readLine();
        t = line.split(" ");
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(t[i]);
        }
    }

    public static void main(String[] args) throws IOException{
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));

        ReadInput();

        Arrays.sort(scores);

        int i = n - x;
        while (i > 0 && scores[i - 1] == scores[i]) {
            i--;
        }
        while (i < n && scores[i] == 0) {
            i++;
        }

        writer.write(String.valueOf(n - i));
        writer.flush();


        reader.close();
        writer.close();
    }
}