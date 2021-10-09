import java.util.Arrays;

/**
 * @author CuiJunJie
 * @create 2021/8/3-18:34
 */
public class QuickSort {
    private int[] arr;

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void sort() {
        _sort(0, arr.length - 1);
    }

    private void _sort(int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left, j = right;

        int t = arr[left];
        while (left < right) {
            while (left < right && arr[right] > t) {
                right--;
            }
            if (left < right) {
                arr[left++] = arr[right];
            }
            while (left < right && arr[left] <= t) {
                left++;
            }
            if (left < right) {
                arr[right--] = arr[left];
            }
        }
        arr[right] = t;

        _sort(i, left - 1);
        _sort(left + 1, j);
    }
}
