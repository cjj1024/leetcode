import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-11-05-15:00
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode createList(int[] vals) {
        if (vals == null || vals.length < 1) {
            return null;
        }

        ListNode head = new ListNode(vals[0]);
        ListNode tail = head;
        for (int i = 1; i < vals.length; i++) {
            ListNode node = new ListNode(vals[i]);
            tail.next = node;
            tail = node;
        }

        return head;
    }

    public static void traversal(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
