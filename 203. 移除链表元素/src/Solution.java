/**
 * @author CuiJunJie
 * @create 2020-10-20-9:53
 */
public class Solution {
    public static void main(String[] args) {
        int[] vals = {1, 1};
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        for (int val : vals) {
            node.next = new ListNode(val);
            node = node.next;
        }

        ListNode list = removeElements(dummy.next, 1);
        for (node = list; node != null; node = node.next) {
            System.out.println(node.val);
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre != null && pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
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