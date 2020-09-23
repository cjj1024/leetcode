/**
 * @author CuiJunJie
 * @create 2020-09-23-11:04
 */

public class Solution {
    public static void main(String[] args) {
//        ["MinStack","push","push","push","getMin","pop","top","getMin"]
//        [[],[-2],[0],[-3],[],[],[],[]]

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
