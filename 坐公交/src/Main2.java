import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            String[] tmp = sc.nextLine().split(" ");
            int k = Integer.parseInt(tmp[0]);
            for(int j=1;j<tmp.length;j++){
                list.get(Integer.parseInt(tmp[j])-1).add(i);
            }
        }

        int[][] conn = new int[n][n];
        for(int[] con:conn){
            Arrays.fill(con,Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            conn[i][i] = 0;
        }
        for (int i=0;i<m;i++){
            List<Integer> cur = list.get(i);
            for(int j=0;j<cur.size();j++){
                for(int k=j+1;k<cur.size();k++){
                    conn[cur.get(j)][cur.get(k)] = 1;
                    conn[cur.get(k)][cur.get(j)] = 1;
                }
            }
        }

        int[][] dist = conn;

        for(int k=0;k<n;k++){
            for (int i=0;i<n;i++) {
                for (int j = 0; j < n; j++){
                    int tmp = (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)?Integer.MAX_VALUE:(dist[i][k]+dist[k][j]);
                    if(dist[i][j]>tmp){
                        dist[i][j] = tmp;
                    }
                }
            }
        }

        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(dist[i][j]);
                if(j!=n-1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
