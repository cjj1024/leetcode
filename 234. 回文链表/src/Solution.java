import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2020-11-05-14:56
 */
public class Solution {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 1};
        ListNode head = ListNode.createList(vals);
//        ListNode.traversal(head);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        head = reverseList(head, slow);

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }

        return true;
    }

    private static ListNode reverseList(ListNode head, ListNode end) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode now = head.next;
        ListNode next = head.next.next;
        head.next = null;
        while (now != end) {
            now.next = dummy.next;
            dummy.next = now;
            now = next;
            next = next.next;
        }

        return dummy.next;
    }

//    public static boolean isPalindrome(ListNode head) {
//        if (head == null) {
//            return true;
//        }
//
//        List<Integer> list = new ArrayList<>();
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//
//        List<Integer> list2 = new ArrayList<>(list);
//        Collections.reverse(list);
//
//        for (int i = 0; i < list.size(); i++) {
//            if (!list.get(i).equals(list2.get(i))) {
//                return false;
//            }
//        }
//
//        return true;
//    }
}