/**
 * @author CuiJunJie
 * @create 2021/8/3-19:09
 */
public class HeapSort {
    private int[] arr;

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void sort() {
        for (int i = arr.length / 2; i >= 0; i--) {
            adjustDown(i, arr.length);
        }

        for (int i = 0; i < arr.length; i++) {
            int t = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[0];
            arr[0] = t;
            adjustDown(0, arr.length - i - 1);
        }
    }

    public void adjustDown(int i, int n) {
        int child = i * 2 + 1;

        int t = arr[i];
        while (child < n) {
            if (child + 1 < n && arr[child] > arr[child + 1]) {
                child++;
            }
            if (arr[child] < t) {
                arr[i] = arr[child];
                i = child;
                child = i * 2 + 1;
            } else {
                break;
            }
        }
        arr[i] = t;
    }

    public void adjustUp(int i) {
        int parent = (i + 1) / 2 - 1;
        int t = arr[i];
        while (parent >= 0 && arr[parent] > t) {
            arr[i] = arr[parent];
            i = parent;
            parent = (i + 1) / 2 - 1;
        }
        arr[i] = t;
    }
}
