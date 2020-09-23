import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2020-09-23-11:14
 */
public class Solution {
    public static void main(String[] args) {
//        intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
        int[] listA = {4,1,8,4,5};
        int[] listB = {5,0,1,8,4,5};
        int intersectVal = 8;
        int skipA = 2, skipB = 3;
        ListNode headA = new ListNode(listA[0]);
        ListNode headB = new ListNode(listB[0]);
        ListNode nodeA = headA;
        for (int i = 1; i < skipA; i++) {
            nodeA.next = new ListNode(listA[i]);
            nodeA = nodeA.next;
        }
        ListNode nodeB = headB;
        for (int i = 1; i < skipB; i++) {
            nodeB.next = new ListNode(listB[i]);
            nodeB = nodeB.next;
        }

        nodeA.next = new ListNode(listA[skipA]);
        nodeB.next = nodeA.next;
        nodeA = nodeA.next;
        for (int i = skipA + 1; i < listA.length; i++) {
            nodeA.next = new ListNode(listA[i]);
            nodeA = nodeA.next;
        }


        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode node1 = headA;
        int len1 = 0;
        while (node1 != null) {
            len1++;
            node1 = node1.next;
        }
        ListNode node2 = headB;
        int len2 = 0;
        while (node2 != null) {
            len2++;
            node2 = node2.next;
        }

        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                headB = headB.next;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

//    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//
//        HashSet<ListNode> set = new HashSet<>();
//        while (headA != null) {
//            set.add(headA);
//            headA = headA.next;
//        }
//        while (headB != null) {
//            if (set.contains(headB)) {
//                return headB;
//            }
//            headB = headB.next;
//        }
//
//        return null;
//    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
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

    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}
