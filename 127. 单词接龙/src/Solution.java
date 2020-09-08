import com.sun.org.apache.xpath.internal.objects.XBoolean;

import java.awt.geom.GeneralPath;
import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020-09-08-9:43
 */
public class Solution {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null) {
            return 0;
        }

        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        for (String s : wordList) {
            map.put(s, id++);
        }
        if (!map.containsKey(endWord)) {
            return 0;
        }
        if (!map.containsKey(beginWord)) {
            map.put(beginWord, id++);
        }

        int len = 0;
        int dest = map.get(endWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        boolean[] used = new boolean[map.size()];
        used[map.get(beginWord)] = true;
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int k = 0; k <size; k++) {
                String now = queue.poll();
                if (map.get(now) == dest) {
                    return len;
                }
                for (int i = 0; i < wordList.size(); i++) {
                    if (used[map.get(wordList.get(i))]) {
                        continue;
                    }
                    if (isValid(wordList.get(i), now)) {
                        queue.add(wordList.get(i));
                        used[map.get(wordList.get(i))] = true;
                    }
                }
            }
        }

        return 0;
    }

    public static boolean isValid(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length() && diff < 2; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }
}
