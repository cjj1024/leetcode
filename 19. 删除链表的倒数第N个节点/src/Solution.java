/**
 * @author cuijunjie
 * @create 2020--04-10:18
 */
public class Solution {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode t  = list;
        for (int i = 2; i < 3; i++) {
            ListNode node = new ListNode(i);
            t.next = node;
            t = node;
        }

        list = removeNthFromEnd(list, 2);

        ListNode node = list;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node = head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }

        ListNode pre = head;
        ListNode now = head;
        while (node != null) {
            pre = now;
            now = now.next;
            node = node.next;
        }

        if (now == head) {
            head = head.next;
        } else {
            pre.next = now.next;
        }

        return head;
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
    ListNode(int x) {
        val = x;
    }
}