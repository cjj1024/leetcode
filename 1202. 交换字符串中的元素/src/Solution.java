import java.util.*;

/**
 * @create CuiJunJie
 * @date 2021/1/11-17:47
 */
public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));
//        pairs.add(Arrays.asList(0, 2));
        System.out.println(smallestStringWithSwaps("dcab", pairs));
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() < 1) {
            return s;
        }

        int[] parents = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            parents[i] = i;
        }

        for (int i = 0; i < pairs.size(); i++) {
            union(parents, pairs.get(i).get(0), pairs.get(i).get(1));
        }

        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int root = find(parents, i);
            if (map.containsKey(root)) {
                map.get(root).offer(s.charAt(i));
            } else {
                PriorityQueue<Character> queue = new PriorityQueue<>();
                queue.offer(s.charAt(i));
                map.put(root, queue);
            }
        }

        StringBuffer sb = new StringBuffer(s.length());
        for (int i = 0; i < s.length(); i++) {
            sb.append(map.get(find(parents, i)).poll());
        }

        return sb.toString();
    }

    private static void union(int[] parents, int x, int y) {
        int rootX = find(parents, x);
        int rootY = find(parents, y);

        if (rootX != rootY) {
            parents[rootX] = rootY;
        }
    }

    private static int find(int[] parents, int x) {
        if (x != parents[x]) {
            parents[x] = find(parents, parents[x]);
        }
        return parents[x];
    }
//    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
//        if (pairs.size() < 1) {
//            return s;
//        }
//
//        int[][] edges = new int[s.length()][s.length()];
//        for (int i = 0; i < pairs.size(); i++) {
//            edges[pairs.get(i).get(0)][pairs.get(i).get(1)] = 1;
//            edges[pairs.get(i).get(1)][pairs.get(i).get(0)] = 1;
//        }
//
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            Integer minIndex = getMin(chars, edges, new boolean[s.length()], i, i, i);
//            char t = chars[i];
//            chars[i] = chars[minIndex];
//            chars[minIndex] = t;
//        }
//
//        return new String(chars);
//    }
//
//    private static Integer getMin(char[] chars, int[][] edges, boolean[] visited, int k, int minIndex, int start) {
//        visited[k] = true;
//        for (int i = 0; i < chars.length; i++) {
//            if (!visited[i] && edges[k][i] == 1) {
//                if (chars[minIndex] > chars[i] && i > start) {
//                    minIndex = i;
//                }
//                Integer t = getMin(chars, edges, visited, i, minIndex, start);
//                if (chars[minIndex] > chars[t] && t > start) {
//                    minIndex = t;
//                }
//            }
//        }
//
//        return minIndex;
//    }
}
