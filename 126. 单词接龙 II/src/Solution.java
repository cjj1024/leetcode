import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020-09-04-14:11
 */
public class Solution {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        List<List<String>> ladders = findLadders(beginWord, endWord, wordList);
        for (List<String> ladder : ladders) {
            for (String s : ladder) {
                System.out.printf("%s ", s);

            }
            System.out.println();
        }
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> wordId = new HashMap<>();
        List<String> idWord = new ArrayList<>();
        int id = 0;
        for (String s : wordList) {
            if (!wordId.containsKey(s)) {
                wordId.put(s, id++);
                idWord.add(s);
            }
        }
        if (!wordId.containsKey(endWord)){
            return new ArrayList<>();
        }
        if (!wordId.containsKey(beginWord)) {
            wordId.put(beginWord, id++);
            idWord.add(beginWord);
        }

        int size = idWord.size();
        List<Integer>[] edges = new List[size];
        for (int i = 0; i < size; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (check(idWord.get(i), idWord.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        int[] cost = new int[size];
        for (int i = 0; i < size; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        int dest = wordId.get(endWord);
        List<List<String>> ret = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> now = new ArrayList<>();
        now.add(wordId.get(beginWord));
        queue.offer(now);
        cost[wordId.get(beginWord)] = 0;

        while (!queue.isEmpty()) {
            now = queue.poll();
            int last = now.get(now.size() - 1);
            if (last == dest) {
                ArrayList<String> path = new ArrayList<>(now.size());
                for (Integer idx : now) {
                    path.add(idWord.get(idx));
                }
                ret.add(path);
            } else {
                List<Integer> next = edges[last];
                for (int i = 0; i < next.size(); i++) {
                    int to = next.get(i);
                    if (cost[last] + 1 <= cost[to]) {
                        cost[to] = cost[last] + 1;
                        ArrayList<Integer> tmp = new ArrayList<>(now);
                        tmp.add(to);
                        queue.offer(tmp);
                    }
                }
            }
        }

        return ret;
    }

    private static boolean check(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length() && diff < 2; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }
}
