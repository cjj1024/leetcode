import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2020-11-05-10:15
 */
class MyQueue {

    Stack<Integer> stack = null;
    Stack<Integer> stack2 = null;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        stack.push(x);
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
