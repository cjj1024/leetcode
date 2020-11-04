/**
 * @author CuiJunJie
 * @create 2020-11-04-11:01
 */
public class Solution {
    public static void main(String[] args) {
        /**
         * Your MyStack object will be instantiated and called as such:
         * MyStack obj = new MyStack();
         * obj.push(x);
         * int param_2 = obj.pop();
         * int param_3 = obj.top();
         * boolean param_4 = obj.empty();
         */

        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.empty());
    }
}
