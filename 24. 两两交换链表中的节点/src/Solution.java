import java.nio.file.attribute.UserDefinedFileAttributeView;

/**
 * @author cuijunjie
 * @create 2020--04-15:02
 */
public class Solution {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        list = swapPairs(list);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

//    public static ListNode swapPairs(ListNode head) {
//        if (head == null) {
//            return head;
//        }
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode preNode = dummy;
//        ListNode nowNode = head;
//
//        while (nowNode != null && nowNode.next != null) {
//            preNode.next = nowNode.next;
//            nowNode.next = nowNode.next.next;
//            preNode.next.next = nowNode;
//            preNode = preNode.next.next;
//            nowNode = preNode.next;
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
}