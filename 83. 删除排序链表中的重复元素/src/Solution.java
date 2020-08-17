/**
 * @author cuijunjie
 * @create 2020--17-15:19
 */
public class Solution {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        int[] values = {1, 1};
        ListNode node = dummy;
        for (int v : values) {
            node.next = new ListNode(v);
            node = node.next;
        }

        ListNode newList = deleteDuplicates(dummy.next);
        while (newList != null) {
            System.out.println(newList.val);
            newList = newList.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(head.val - 1);
        ListNode tail = dummy;

        ListNode pre = dummy;
        head = head;
        while (head != null) {
            if (pre.val != head.val) {
                tail.next = head;
                tail = tail.next;
                pre = head;
                head = head.next;
            } else {
                while (head != null && pre.val == head.val) {
                    pre = head;
                    head = head.next;
                }
            }
        }
        if (tail != null) {
            tail.next = null;
        }

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
