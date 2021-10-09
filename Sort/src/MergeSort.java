/**
 * @author CuiJunJie
 * @create 2021/8/3-17:32
 */
public class MergeSort {
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

    public void _sort(int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        _sort(left, mid);
        _sort(mid + 1, right);

        int i = left, j = mid + 1, k = 0;
        int[] arr2 = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                arr2[k++] = arr[i++];
            } else {
                arr2[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            arr2[k++] = arr[i++];
        }
        while (j <= right) {
            arr2[k++] = arr[j++];
        }

        i = left;
        k = 0;
        while (i <= right) {
            arr[i++] = arr2[k++];
        }
    }
}
