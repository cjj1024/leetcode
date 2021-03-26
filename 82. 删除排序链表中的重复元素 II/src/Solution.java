import com.sun.org.apache.xalan.internal.lib.NodeInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cuijunjie
 * @create 2020--17-9:48
 */
public class Solution {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        int[] values = {1, 2, 3, 3, 4, 4, 5};
        ListNode node = dummy;
        for (int v : values) {
            node.next = new ListNode(v);
            node = node.next;
        }
        ListNode ret = deleteDuplicates(dummy.next);
        node = ret;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        Map<Integer, Integer> map = new HashMap<>();
        while (head != null) {
            map.put(head.val, map.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }

        head = dummy;
        while (head.next != null) {
            if (map.get(head.next.val) != 1) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }

//    public static ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode pre = dummy;
//        while (head != null && head.next != null) {
//            if (pre.next.val != head.next.val) {
//                pre = pre.next;
//                head = head.next;
//            }
//            else {
//                while (head.next != null && pre.next.val == head.next.val) {
//                    head = head.next;
//                }
//                pre.next = head.next;
//                head = head.next;
//            }
//        }
//
//        return dummy.next;
//    }

//    public static ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode dummy = new ListNode(-1);
//        ListNode tail = dummy;
//
//        ListNode pre = head;
//        while (head != null) {
//            while (head != null && pre.val == head.val) {
//                head = head.next;
//            }
//            if (pre.next == head){
//                tail.next = pre;
//                tail = tail.next;
//            }
//            pre = head;
//        }
//        if (tail != null) {
//            tail.next = null;
//        }
//
//        return dummy.next;
//    }
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

    public ListNode() {
    }
}