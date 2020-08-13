import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--13-14:07
 */
public class Solution {
    public static void main(String[] args) {
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};

        int maxWidth = 16;
        List<String> strs = fullJustify(words, maxWidth);
        for (String str : strs) {
            System.out.println(str);
        }
    }

    public static void merge(List<String> ret, List<String> tmp, int maxWidth) {
        StringBuilder sb = new StringBuilder(maxWidth);
        if (tmp.size() == 1) {
            sb.append(tmp.get(0));
            for (int i = sb.length(); i < maxWidth; i++) {
                sb.append(' ');
            }
            ret.add(sb.toString());
            return;
        }

        int width = 0;
        for (String s : tmp) {
            width += s.length();
        }
        int blankNum = (maxWidth - width) / (tmp.size() - 1);
        int blankNum2 = (maxWidth  - width - blankNum * (tmp.size() - 1));
        StringBuilder blank1 = new StringBuilder(blankNum + 1);
        for (int i = 0; i < blankNum + 1; i++) {
            blank1.append(' ');
        }
        StringBuilder blank2 = new StringBuilder(blankNum);
        for (int i = 0; i < blankNum; i++) {
            blank2.append(' ');
        }

        for (int i = 0; i < blankNum2; i++) {
            sb.append(tmp.get(i));
            sb.append(blank1);
        }
        for (int i = blankNum2; i < tmp.size() - 1; i++) {
            sb.append(tmp.get(i));
            sb.append(blank2);
        }
        sb.append(tmp.get(tmp.size() - 1));
        ret.add(sb.toString());
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        if (words.length < 1) {
            return null;
        }
        List<String> ret = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        int width = 0;
        String word;
        for (int w = 0; w < words.length; w++) {
            word = words[w];

            if (w == words.length - 1) {
                if (width + word.length() <= maxWidth) {
                    tmp.add(word);
                } else {
                    merge(ret, tmp, maxWidth);
                    tmp.clear();
                    tmp.add(word);
                }
                StringBuilder sb = new StringBuilder(maxWidth);
                for (int i = 0; i < tmp.size() - 1; i++) {
                    sb.append(tmp.get(i));
                    sb.append(' ');
                }
                sb.append(tmp.get(tmp.size() - 1));
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(' ');
                }
                ret.add(sb.toString());
                return ret;
            }

            if (width + word.length() <= maxWidth) {
                tmp.add(word);
                width += word.length() + 1;
            } else {
                merge(ret, tmp, maxWidth);
                width = 0;
                tmp.clear();
                tmp.add(word);
                width += word.length() + 1;
            }
        }

        return ret;
    }
}
