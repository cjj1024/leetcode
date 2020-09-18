import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author CuiJunJie
 * @create 2020-09-17-10:50
 */
public class Solution {
    public static void main(String[] args) {
        int[] vals = {3,2,0,-4};
        HashMap<Integer, ListNode> map = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            map.put(i, new ListNode(vals[i]));
        }
        for (int i = 0; i < vals.length - 1; i++) {
            map.get(i).next = map.get(i + 1);
        }
        int pos = 1;
        if (pos != -1) {
            map.get(vals.length - 1).next = map.get(pos);
        }

        ListNode node = detectCycle(map.get(0));
        System.out.println(node == null ? "null" : node.val);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

//    public static ListNode detectCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return null;
//        }
//
//        Set<ListNode> set = new HashSet<>();
//        while (head != null) {
//            if (set.contains(head)) {
//                return head;
//            } else {
//                set.add(head);
//            }
//
//            head = head.next;
//        }
//
//        return null;
//    }
}
/*
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}