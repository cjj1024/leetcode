/**
 * @author CuiJunJie
 * @create 2021/8/3-18:08
 */
public class SearchSort {
    private int[] arr;

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void sort() {
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[k] > arr[j]) {
                    k = j;
                }
            }
            int t = arr[k];
            arr[k] = arr[i];
            arr[i] = t;
        }
    }
}
