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


    public static void readInput() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(reader.readLine());
        values = new int[N];
        int i = 0;
        for (String s : reader.readLine().split(" ")) {
            values[i++] = Integer.parseInt(s);
        }
    }

    public static void main(String[] args) throws IOException{
        readInput();
        buildTree(0);
    }

    private static Node buildTree(int node) {
        if (node == N) {
            minValue = Math.min(minValue, getValues());
            return null;
        }
        if (node < 0) {
            return null;
        }


    }

    private static int getValues() {
        return 0;
    }
}