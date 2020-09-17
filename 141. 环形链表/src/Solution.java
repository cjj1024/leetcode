import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-09-17-10:31
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

        System.out.println(hasCycle(map.get(0)));
    }
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }


//    public static boolean hasCycle(ListNode head) {
//        if (head == null) {
//            return false;
//        }
//        HashSet<ListNode> set = new HashSet<>();
//        while (head != null) {
//            if (set.contains(head)) {
//                return true;
//            } else {
//                set.add(head);
//            }
//            head = head.next;
//        }
//
//        return false;
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
