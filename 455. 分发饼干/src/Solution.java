import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2020/12/25-10:03
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println(findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}));
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{3}));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        while (i < g.length) {
            while (j < s.length && g[i] > s[j]) {
                j++;
            }
            if (j >= s.length) {
                break;
            }
            i++;
            j++;
        }

        return i;
    }
}
