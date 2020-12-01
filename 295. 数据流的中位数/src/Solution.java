/**
 * @author CuiJunJie
 * @create 2020/11/30-16:28
 */
public class Solution {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(1);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(2);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(3);
//        System.out.println(medianFinder.findMedian());
//        ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum",
//        "findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian",
//        "addNum","findMedian","addNum","findMedian","addNum","findMedian"]
//        [[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]]
//        [null,null,6.00000,null,8.00000,null,6.00000,null,6.00000,null,6.00000,null,5.50000,null,6.00000,
//        null,5.50000,null,5.00000,null,4.00000,null,3.00000]
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
    }
}
