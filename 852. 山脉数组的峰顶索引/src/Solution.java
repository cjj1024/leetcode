/**
 * @author CuiJunJie
 * @create 2021/6/15-9:44
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0,10,5,2}));
        System.out.println(peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }

        return -1;
    }
}
