/**
 * @author CuiJunJie
 * @create 2020-11-11-9:52
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println(hIndex(new int[]{10}));
        System.out.println(hIndex(new int[]{0, 1}));
    }

    public static int hIndex(int[] citations) {
        if (citations == null || citations.length < 1) {
            return 0;
        }

        int len = citations.length;

        int left = 0;
        int right = citations.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (citations[mid] < len - mid) {
                left = mid + 1;
            } else if (citations[mid] > left - mid) {
                right = mid - 1;
            } else {
                return len - mid;
            }
        }

        return len - left;
    }
}
