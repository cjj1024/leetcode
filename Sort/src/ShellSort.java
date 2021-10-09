/**
 * @author CuiJunJie
 * @create 2021/8/19-15:33
 */
public class ShellSort {
    private int[] arr;

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int t = arr[i];
                int j = i - gap;
                for (; j >= 0; j -= gap) {
                    if (arr[j] > t) {
                        arr[j + gap] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + gap] = t;
            }
        }
    }
}
