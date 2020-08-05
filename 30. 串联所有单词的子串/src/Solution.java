import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cuijunjie
 * @create 2020--05-11:04
 */
public class Solution {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return ret;
        }

        HashMap<String, Integer> allWords = new HashMap<>();
        for (String word : words) {
            int value = allWords.getOrDefault(word, 0);
            allWords.put(word, value + 1);
        }

        int wordLen = words[0].length();
        for (int i = 0; i < s.length() - wordLen * wordNum + 1; i++) {
            Map<String, Integer> hasWord = new HashMap<>();
            int j;
            for (j = 0; j < wordNum; j++) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                if (allWords.containsKey(word)) {
                    int value = hasWord.getOrDefault(word, 0);
                    hasWord.put(word, value + 1);
                    if (hasWord.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (j == wordNum) {
                ret.add(i);
            }
        }

        return ret;
    }
}
