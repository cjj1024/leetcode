import org.omg.PortableInterceptor.INACTIVE;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author CuiJunJie
 * @create 2020/11/30-16:29
 */
public class MedianFinder {
    private PriorityQueue<Integer> left = null;
    private PriorityQueue<Integer> right = null;
    private boolean isOdd = false;

    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        right = new PriorityQueue<>(Comparator.comparingInt(o -> o));
    }

    public void addNum(int num) {
        if (left.size() < right.size()) {
            if (!right.isEmpty() && num > right.peek()) {
                left.add(right.poll());
                right.add(num);
            } else {
                left.add(num);
            }
        } else {
            if (!left.isEmpty() && num < left.peek()) {
                right.add(left.poll());
                left.add(num);
            } else {
                right.add(num);
            }
        }
        isOdd = !isOdd;
    }

    public double findMedian() {
        if (isOdd) {
            return right.peek();
        } else {
            return (left.peek() + right.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
