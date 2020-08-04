import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author cuijunjie
 * @create 2020--04-14:17
 */
public class Solution {
    public static void main(String[] args) {
        ListNode list1, list2, list3;
        list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{list1, list2, list3};

        ListNode list = mergeKLists(lists);
        for (ListNode node = list; node != null; node = node.next) {
            System.out.println(node.val);
        }
    }

    // 优先队列
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode list = head;

        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }

        ListNode node = null;
        while (!priorityQueue.isEmpty()) {
            node = priorityQueue.poll();
            list.next = node;
            list = list.next;
            if (node.next != null) {
                node = node.next;
                priorityQueue.add(node);
            }
        }

        return head.next;
    }

    // 分治合并
//    public static ListNode mergeKLists(ListNode[] lists) {
//        return merge(lists, 0, lists.length - 1);
//    }

    public static ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

//    public static ListNode mergeKLists(ListNode[] lists) {
//
//        ListNode list, head;
//        int minNode = 0;
//        int minValue = Integer.MAX_VALUE;
//        boolean flag = false;
//        for (int i = 0; i < lists.length; i++) {
//            if (lists[i] != null && minValue > lists[i].val) {
//                flag = true;
//                minValue = lists[i].val;
//                minNode = i;
//            }
//        }
//
//        if (flag == false) {
//            return null;
//        }
//
//        list = new ListNode(minValue);
//        head = list;
//        lists[minNode] = lists[minNode].next;
//
//
//
//        while (true) {
//            flag = false;
//            minValue = Integer.MAX_VALUE;
//            for (int i = 0; i < lists.length; i++) {
//                if (lists[i] != null && minValue > lists[i].val) {
//                    flag = true;
//                    minValue = lists[i].val;
//                    minNode = i;
//                }
//            }
//            if (flag == false) {
//                break;
//            }
//            list.next = new ListNode(minValue);
//            list = list.next;
//            lists[minNode] = lists[minNode].next;
//        }
//
//        return head;
//    }

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