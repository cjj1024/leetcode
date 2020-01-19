/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode t = new ListNode(3);
        t.next = null;
        l1.next = t;
        ListNode l2 = new ListNode(4);
        t = new ListNode(4);
        t.next = null;
        l2.next = t;
        ListNode res = addTwoNumbers(l1, l2);
        System.out.println(res.val);
        System.out.println(res.next.val);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1, tmp2;

        int k = l1.val + l2.val;
        int k1 = k / 10;
        int k2 = k % 10;
        ListNode res = new ListNode(k2);
        tmp1 = res;
        l1 = l1.next;
        l2 = l2.next;
        for (; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next) {
            k = l1.val + l2.val + k1;
            k1 = k / 10;
            k2 = k % 10;
            tmp1.next = new ListNode(k2);
            tmp1 = tmp1.next;
        }
        for (; l1 != null; l1 = l1.next) {
            k = l1.val + k1;
            k1 = k / 10;
            k2 = k % 10;
            tmp1.next = new ListNode(k2);
            tmp1 = tmp1.next;
        }
        for (; l2 != null; l2 = l2.next) {
            k = l2.val + k1;
            k1 = k / 10;
            k2 = k % 10;
            tmp1.next = new ListNode(k2);
            tmp1 = tmp1.next;
        }
        if (k1 != 0) {
            tmp1.next = new ListNode(k1);
            tmp1 = tmp1.next;
        }

        tmp1.next = null;

        return res;
    }
}