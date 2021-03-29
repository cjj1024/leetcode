import java.util.*;
import java.util.stream.Collectors;

/**
 * @author CuiJunJie
 * @create 2021/3/12-16:10
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[50000];
        Random random = new Random();
        for (int i = 0; i < 50000; i++) {
            arr[i] = i;
        }
        long start = System.currentTimeMillis();
        Arrays.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
//        System.out.println(countPalindromicSubsequences("bccb"));    // 6
//        System.out.println(countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
    }

    public static int countPalindromicSubsequences(String S) {
        return 0;
    }

    public static int countPalindromicSubsequences2(String S) {
        char[] chars = S.toCharArray();

        return backtrace(chars, 0, new StringBuilder(S.length()));
    }

    private static Set<String> set = new HashSet<>();
    private static int backtrace(char[] chars, int i, StringBuilder sb) {
        int num = 0;
        if (isPalindrom(sb)) {
            if (!set.contains(sb.toString())) {
                num++;
                System.out.println(sb);
                set.add(sb.toString());
            }
        }

        if (i == chars.length) {
            return num;
        }

        sb.append(chars[i]);
        num += backtrace(chars, i + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        num += backtrace(chars, i + 1, sb);

        return num;
    }

    private static boolean isPalindrom(StringBuilder sb) {
        if (sb.length() < 1) {
            return false;
        }
        if (sb.length() == 1) {
            return true;
        }
        int i = 0;
        int j = sb.length() - 1;
        while (i < j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
