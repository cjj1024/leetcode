import java.util.*;

/**
 * @author CuiJunJie
 * @create 2021/1/6-9:38
 */
public class Solution {
    public static void main(String[] args) {
//        List<List<String>> equations = new ArrayList<>();
//        equations.add(Arrays.asList("a","b"));
//        equations.add(Arrays.asList("b","c"));
//        double[] value = new double[]{2.0,3.0};
//        List<List<String>> queries = new ArrayList<>();
//        queries.add(Arrays.asList("a","c"));
//        queries.add(Arrays.asList("b","a"));
//        queries.add(Arrays.asList("a","e"));
//        queries.add(Arrays.asList("a","a"));
//        queries.add(Arrays.asList("x","x"));
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("x1", "x2"));
        equations.add(Arrays.asList("x2", "x3"));
        equations.add(Arrays.asList("x3", "x4"));
        equations.add(Arrays.asList("x4", "x5"));
        double[] value = new double[]{3.0, 4.0, 5.0, 6.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("x1", "x5"));
        queries.add(Arrays.asList("x5", "x2"));
        queries.add(Arrays.asList("x2", "x4"));
        queries.add(Arrays.asList("x2", "x2"));
        queries.add(Arrays.asList("x2", "x9"));
        queries.add(Arrays.asList("x9", "x9"));
        System.out.println(Arrays.toString(calcEquation(equations, value, queries)));
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        int num = 0;
        for (List<String> eq : equations) {
            if (!map.containsKey(eq.get(0))) {
                map.put(eq.get(0), num++);
            }
            if (!map.containsKey(eq.get(1))) {
                map.put(eq.get(1), num++);
            }
        }

        double[][] edges = new double[num][num];
        for (int i = 0; i < num; i++) {
            edges[i][i] = 1.0;
        }
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            edges[map.get(a)][map.get(b)] = values[i];
            edges[map.get(b)][map.get(a)] = 1 / values[i];
        }

        double[] ret = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            if (!map.containsKey(query.get(0)) || !map.containsKey(query.get(1))) {
                ret[i] = -1.0;
            } else {
                Double d = getResult(edges, new boolean[num], map.get(query.get(0)), map.get(query.get(1)));
                ret[i] = d == null ? -1 : d;
            }
        }

        return ret;
    }

    private static Double getResult(double[][] edges, boolean[] visited, int a, int b) {
        if (edges[a][b] != 0) {
            return edges[a][b];
        }
        visited[a] = true;
        for (int i = 0; i < edges.length; i++) {
          if (!visited[i] && edges[a][i] != 0) {
              visited[i] = true;
              Double d = getResult(edges, visited, i, b);
              if (d != null) {
                  return d * edges[a][i];
              }
          }
        }

        return null;
    }
}
