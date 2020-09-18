import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2020-09-18-10:12
 */
public class Solution {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 5};
        HashMap<Integer, ListNode> map = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            map.put(i, new ListNode(vals[i]));
        }
        for (int i = 0; i < vals.length - 1; i++) {
            map.get(i).next = map.get(i + 1);
        }

        reorderList(map.get(0));

        for (ListNode node = map.get(0); node != null; node = node.next) {
            System.out.println(node.val);
        }
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            stack.push(slow);
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode tmp = slow;
        slow = slow.next;
        tmp.next = null;
        if (fast == null) {
            stack.pop();
        }

        ListNode now = slow;
        ListNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            now = slow;
            slow = slow.next;
            now.next = node.next;
            node.next = now;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}