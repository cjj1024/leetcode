import java.lang.reflect.Array;
import java.util.*;

/**
 * @author CuiJunJie
 * @create 2021/5/20-9:24
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    static class WordFrequent {
        String word;
        Integer frequent;

        public WordFrequent(String word, Integer frequent) {
            this.word = word;
            this.frequent = frequent;
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<WordFrequent> list = new ArrayList<>();
        for (String word : map.keySet()) {
            list.add(new WordFrequent(word, map.get(word)));
        }

        Collections.sort(list, ((o1, o2) -> {
            if (o1.frequent > o2.frequent) {
                return -1;
            }
            if (o1.frequent < o2.frequent) {
                return 1;
            }

            return o1.word.compareTo(o2.word);
        }));

        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ret.add(list.get(i).word);
        }

        return ret;
    }
}
