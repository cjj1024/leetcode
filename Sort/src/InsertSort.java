/**
 * @author CuiJunJie
 * @create 2021/8/3-18:21
 */
public class InsertSort {
    private int[] arr;

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void sort() {
        for (int i = 1; i < arr.length; i++) {
            int t = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > t) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = t;
        }
    }
}
