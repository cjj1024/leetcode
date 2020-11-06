import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-11-06-16:12
 */
public class Solution {

    private  static ListNode head;
    static {
        Integer[] vals = {4,5,1,9};
        head = ListNode.createList(vals);
    }

    public static void main(String[] args) {
        deleteNode(head.next.next);
        ListNode.traversal(head);
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
