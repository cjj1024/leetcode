/**
 * @author CuiJunJie
 * @create 2020-10-28-11:01
 */
public class MaxHeap {
    private int[] heap;
    private int length;

    public MaxHeap(int[] heap, int length) {
        this.heap = heap;
        this.length = length;
    }

    public void init() {
        for (int i = length / 2; i >= 0; i--) {
            adjust(i);
        }
    }

    public void adjust(int parent) {
        int leftChild = parent * 2 + 1;
        int rightChild = leftChild + 1;
        int largest = parent;
        if (leftChild < length && heap[leftChild] > heap[largest]) {
            largest = leftChild;
        }
        if (rightChild < length && heap[rightChild] > heap[largest]) {
            largest = rightChild;
        }
        if (largest != parent) {
            int tmp = heap[parent];
            heap[parent] = heap[largest];
            heap[largest] = tmp;
            adjust(largest);
        }
    }

    public void delete() {
        heap[0] = heap[length - 1];
        length--;
        adjust(0);
    }

    public int getMax() {
        return heap[0];
    }
}
