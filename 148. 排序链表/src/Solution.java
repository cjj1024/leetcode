import java.util.HashMap;

/**
 * @author CuiJunJie
 * @create 2020-09-19-10:02
 */
public class Solution {
    public static void main(String[] args) {
        int[] vals = {3, 2};
        HashMap<Integer, ListNode> map = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            map.put(i, new ListNode(vals[i]));
        }
        for (int i = 0; i < vals.length - 1; i++) {
            map.get(i).next = map.get(i + 1);
        }

        ListNode head = sortList(map.get(0));
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode mid = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            mid = slow;
            slow = slow.next;
        }

        if (fast != null) {
            mid = mid.next;
        } else {
            slow = mid;
        }

        mid = mid.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        ListNode dummy = new ListNode(-1);
        head = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }

        if (left != null) {
            head.next = left;
        }
        if (right != null) {
            head.next = right;
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}