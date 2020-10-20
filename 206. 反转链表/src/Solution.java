/**
 * @author CuiJunJie
 * @create 2020-10-20-11:10
 */
public class Solution {
    public static void main(String[] args) {
        int[] vals = {1};
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        for (int val : vals) {
            node.next = new ListNode(val);
            node = node.next;
        }

        ListNode list = reverseList(dummy.next);
        for (node = list; node != null; node = node.next) {
            System.out.println(node.val);
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode now = head;
        ListNode next = now.next;
        head.next = null;
        while (next != null) {
            now = next;
            next = next.next;
            now.next = dummy.next;
            dummy.next = now;
        }

        return dummy.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}