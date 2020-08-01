import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author cuijunjie
 * @create 2020--31-15:02
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        if (x / 10 == 0) {
            return true;
        }

        int rev = 0;
        while (rev < x) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        if (rev == x || rev / 10 == x) {
            return true;
        } else {
            return false;
        }

    }

//    public static boolean isPalindrome(int x) {
//        if (x < 0) {
//            return false;
//        }
//
//        Stack<Integer> stack = new Stack<>();
//        Queue<Integer> queue = new LinkedList<>();
//        int t = 0;
//        while (x != 0) {
//            t = x % 10;
//            x = x / 10;
//            stack.push(t);
//            queue.offer(t);
//        }
//
//        boolean ret = true;
//        while (!stack.isEmpty()) {
//            if ((int) stack.pop() != (int) queue.poll()) {
//                ret = false;
//            }
//        }
//
//        return ret;
//    }
}
