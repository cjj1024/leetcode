import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2020-10-19-14:33
 */
public class UnionFind {
    private int count;
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(rank, 1);
    }

    public int find(int x) {
        while (x != parent[x]) {
            x = parent[x];
        }

        int root = x;
        while (x != parent[x]) {
            int tmp = parent[x];
            parent[x] = root;
            x = tmp;
        }

        return root;
    }

    public void union(int x1, int x2) {
        int x1Root = find(x1);
        int x2Root = find(x2);

        if (x1Root == x2Root) {
            return;
        }

        if (rank[x1Root] > rank[x2Root]) {
            parent[x2Root] = x1Root;
        } else if (rank[x1Root] < rank[x2Root]) {
            parent[x1Root] = x2Root;
        } else {
            parent[x1Root] = x2Root;
            rank[x1Root]++;
        }

        count--;
    }

    public int getCount() {
        return count;
    }
}
