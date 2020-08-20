/**
 * @author CuiJunJie
 * @create 2020-08-20-11:13
 */
public class Solution {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        int[] vals = {1, 2, 3, 4, 5};
        ListNode node = dummy;
        for (int val : vals) {
            node.next = new ListNode(val);
            node = node.next;
        }

        ListNode list = reverseBetween(dummy.next, 1, 5);
        for (; list != null; list = list.next) {
            System.out.println(list.val);
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || n - m < 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode first = dummy;
        int i = 0;
        while (i < m - 1) {
            first = first.next;
            ++i;
        }

        ListNode second = first.next;
        ListNode pre;
        ListNode next = first.next;

        while (i < n) {
            pre = next;
            next = next.next;
            pre.next = first.next;
            first.next = pre;
            ++i;
        }

        second.next = next;
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
