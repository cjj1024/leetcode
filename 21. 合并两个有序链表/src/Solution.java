import java.util.List;

/**
 * @author cuijunjie
 * @create 2020--04-10:47
 */
public class Solution {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode node = new ListNode(2);
        list1.next = node;
        ListNode node2 = new ListNode(4);
        node.next = node2;

        ListNode list2 = new ListNode(1);
        node = new ListNode(3);
        list2.next = node;
        node2 = new ListNode(4);
        node.next = node2;

        ListNode list = mergeTwoLists(list1, list2);
        node = list;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return  l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        ListNode list;
//        if (l1.val < l2.val) {
//            list = new ListNode(l1.val);
//            l1 = l1.next;
//        } else {
//            list = new ListNode(l2.val);
//            l2 = l2.next;
//        }
//        ListNode next = list;
//
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                next.next = new ListNode(l1.val);
//                l1 = l1.next;
//            } else {
//                next.next = new ListNode(l2.val);;
//                l2 = l2.next;
//            }
//            next = next.next;
//        }
//        while (l1 != null) {
//            next.next = new ListNode(l1.val);;
//            l1 = l1.next;
//            next = next.next;
//        }
//        while (l2 != null) {
//            next.next = new ListNode(l2.val);;
//            l2 = l2.next;
//            next = next.next;
//        }
//
//        return list;
//    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}