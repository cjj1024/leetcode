import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author CuiJunJie
 * @create 2020/11/30-11:23
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("bfrbs"));
        System.out.println(reorganizeString("ogccckcwmbmxtsbmozli"));
    }
    public static String reorganizeString(String S) {
        int[] alphabet = new int[26];
        for (int i = 0; i < S.length(); i++) {
            alphabet[S.charAt(i) - 'a']++;
        }

        int maxNum = Arrays.stream(alphabet).max().getAsInt();
        if (maxNum > (S.length() + 1) / 2) {
            return "";
        }

        PriorityQueue<Character> queue = new PriorityQueue<>(Comparator.comparingInt(c -> -alphabet[c - 'a']));
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > 0) {
                queue.offer((char) (i + 'a'));
            }
        }

        StringBuffer sb = new StringBuffer(S.length());
        while (queue.size() > 1) {
            char c1 = queue.poll();
            char c2 = queue.poll();
            sb.append(c1);
            sb.append(c2);
            int index1 = c1 - 'a';
            int index2 = c2 - 'a';
            alphabet[index1]--;
            alphabet[index2]--;
            if (alphabet[index1] > 0) {
                queue.offer((char) (index1 + 'a'));
            }
            if (alphabet[index2] > 0) {
                queue.offer((char) (index2 + 'a'));
            }
        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }

//    public static String reorganizeString(String S) {
//        int[] alphabet = new int[26];
//        for (int i = 0; i < S.length(); i++) {
//            alphabet[S.charAt(i) - 'a']++;
//        }
//
//        int maxNum = Arrays.stream(alphabet).max().getAsInt();
//        if (maxNum > (S.length() + 1) / 2) {
//            return "";
//        }
//
//        StringBuffer sb = new StringBuffer(S);
//        int j = 0;
//        while (true) {
//            maxNum = alphabet[0];
//            int index = 0;
//            for (int k = 0; k < alphabet.length; k++) {
//                if (maxNum < alphabet[k]) {
//                    maxNum = alphabet[k];
//                    index = k;
//                }
//
//            }
//            if (maxNum == 0) {
//                break;
//            }
//            for (int i = 0; i < maxNum; i++) {
//                sb.setCharAt(j, (char) (index + 'a'));
//                j += 2;
//                if (j >= S.length()) {
//                    j = 1;
//                }
//            }
//            alphabet[index] = 0;
//        }
//
//        return sb.toString();
//    }
}
