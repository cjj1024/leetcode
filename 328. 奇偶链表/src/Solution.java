import javax.management.relation.RoleList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-11-13-9:52
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new Integer[]{1, 2, 3, 4, 5});
        ListNode listNode = oddEvenList(head);
        ListNode.traversal(listNode);

        System.out.println();
        head = ListNode.createList(new Integer[]{2, 1, 3, 5, 6, 4, 7});
        listNode = oddEvenList(head);
        ListNode.traversal(listNode);

        System.out.println();
        head = ListNode.createList(new Integer[]{1, 2, 3});
        listNode = oddEvenList(head);
        ListNode.traversal(listNode);

        System.out.println();
        head = ListNode.createList(new Integer[]{1, 2, 3, 4});
        listNode = oddEvenList(head);
        ListNode.traversal(listNode);
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode oddNode = head;
        ListNode evenNode = head.next;
        while (evenNode != null && evenNode.next != null) {
            ListNode t = evenNode.next;
            evenNode.next = evenNode.next.next;
            evenNode = evenNode.next;
            t.next = oddNode.next;
            oddNode.next = t;
            oddNode = oddNode.next;
        }

        return head;
    }
}
