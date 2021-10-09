import java.io.*;

/**
 * @author CuiJunJie
 * @create 2021/7/31-15:25
 */
public class Main {
    private static BufferedReader reader;
    private static BufferedWriter writer;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static int T;
    private static int n;
    private static int[][] ren;
    private static int[] shenfen;


    public static void main(String[] args) throws IOException {
        readT();

        writer.write("\n");
        for (int t = 0; t < T; t++) {
            readData();
            int langId = -1;
            for (int i = 0; i < n; i++) {
                if (shenfen[i] == 1) {
                    langId = i;
                    break;
                }
            }

            boolean[] dead = new boolean[n];
            int survior = n;
            boolean flag = true;
            while (true) {
                int deadId = -1;
                for (int i = 0; i < n; i++) {
                    int index = ren[langId][i] - 1;
                    if (!dead[index]) {
                        dead[index] = true;
                        deadId = index;
                        if (deadId == langId) {
                            writer.write("lieren");
                            flag = false;
                        } else {
                            survior--;
                            if (survior <= 2) {
                                writer.write("langren");
                                flag = false;
                                break;
                            }
                        }
                        break;
                    }
                }

                if (!flag) {
                    break;
                }

                for (int i = 0; i < n; i++) {
                    int index = ren[deadId][i] - 1;
                    if (!dead[index]) {
                        dead[index] = true;
                        deadId = index;
                        if (deadId == langId) {
                            writer.write("lieren");
                            flag = false;
                        } else {
                            survior--;
                            if (survior <= 2) {
                                writer.write("langren");
                                flag = false;
                                break;
                            }
                        }
                        break;
                    }
                }

                if (!flag) {
                    break;
                }
            }
            writer.write("\n");
            writer.flush();
        }

        reader.close();
        writer.close();
    }

    private static void readT() throws IOException {
        T = Integer.parseInt(reader.readLine());
    }

    private static void readData() throws IOException {
        n = Integer.parseInt(reader.readLine());
        shenfen = new int[n];
        ren = new int[n][n];

        String[] t = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            shenfen[i] = Integer.parseInt(t[i]);
        }

        for (int i = 0; i < n; i++) {
            t = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                ren[i][j] = Integer.parseInt(t[j]);
            }
        }
    }
}
