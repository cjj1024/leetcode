/**
 * @author cuijunjie
 * @create 2020--12-16:59
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        head = rotateRight(head, 1);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode node = head;
        ListNode tail = dummy;
        int num = 0;
        while (node != null) {
            num++;
            node = node.next;
            tail = tail.next;
        }


        k = k % num;
        if (k == 0) {
            return head;
        }

        int start = num - k - 1;
        node = head;
        for (int i = 0; i < start; i++) {
            node = node.next;
        }

        dummy.next = node.next;
        node.next = null;
        tail.next = head;


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