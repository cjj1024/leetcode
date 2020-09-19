import java.util.HashMap;

/**
 * @author CuiJunJie
 * @create 2020-09-18-16:32
 */
public class Solution {
    public static void main(String[] args) {
        int[] vals = {3, 2, 4, 1};
        HashMap<Integer, ListNode> map = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            map.put(i, new ListNode(vals[i]));
        }
        for (int i = 0; i < vals.length - 1; i++) {
            map.get(i).next = map.get(i + 1);
        }

        ListNode head = insertionSortList(map.get(0));

        for (ListNode node = head; node != null; node = node.next) {
            System.out.println(node.val);
        }
    }

    public static ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        while (head != null && head.next != null) {
            while (head.next != null && head.val < head.next.val) {
                head = head.next;
            }

            if (head.next == null) {
                break;
            }

            ListNode node1 = head.next;
            ListNode node2 = dummy;
            head.next = head.next.next;

            while (node2.next.val < node1.val) {
                node2 = node2.next;
            }
            node1.next = node2.next;
            node2.next = node1;
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