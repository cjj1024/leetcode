import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--04-15:45
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = reverseKGroup(head, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = head;
        ListNode next = head;
        ListNode tmp = head;
        ListNode tmp2 = head;
        ListNode ret = null;
        int i = 1;
        while (next != null) {
            tmp = dummy.next;
            for (i = 1; i < k && tmp != null; i++) {
                tmp = tmp.next;
            }

            if (i < k || tmp == null) {
                break;
            }
            tmp2 = dummy.next;

            next = dummy.next.next;
            dummy.next.next = tmp.next;
            for (i = 1; i < k; i++) {
                node = next;
                next = next.next;
                node.next = dummy.next;
                dummy.next = node;
            }
            if (ret == null) {
                ret = dummy.next;
            }
            dummy = tmp2;
        }

        return ret;
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