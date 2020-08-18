/**
 * @author cuijunjie
 * @create 2020--18-14:39
 */
public class Solution {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        int[] vals = {4, 1};
        ListNode node = dummy;
        for (int val : vals) {
            node.next = new ListNode(val);
            node = node.next;
        }

        ListNode newList = partition(dummy.next, 3);
        for(node = newList; node != null; node = node.next) {
            System.out.println(node.val);
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode tail1 = dummy1;
        ListNode tail2 = dummy2;

        ListNode next = head;
        ListNode node;
        while ( next != null) {
            if (next.val < x) {
                node  = next;
                next = next.next;
                tail1.next = node;
                tail1 = tail1.next;
            } else {
                node  = next;
                next = next.next;
                tail2.next = node;
                tail2 = tail2.next;
            }
        }
        tail1.next = dummy2.next;
        tail2.next = null;

        return dummy1.next;
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