import javax.swing.tree.TreeNode;

/**
 * @author CuiJunJie
 * @create 2020-08-28-10:32
 */
public class Solution {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        int[] vals = {-10, -3, 0, 5, 9};
        ListNode node = dummy;
        for (int val : vals) {
            node.next = new ListNode(val);
            node = node.next;
        }

        MyTreeNode tree = sortedListToBST(dummy.next);
        preOrder(tree);
    }

    public static MyTreeNode sortedListToBST(ListNode head) {
//        return createTree(head, null);

        int length = 0;
        for (ListNode node = head; node != null; node = node.next) {
            length++;
        }
        globalHead = head;
        return createTree(0, length - 1);
    }

    private static ListNode globalHead = null;
    public static MyTreeNode createTree(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right + 1) >> 1;
        MyTreeNode root = new MyTreeNode();
        root.left = createTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = createTree(mid + 1, right);

        return root;
    }


//    public static MyTreeNode createTree(ListNode start, ListNode end) {
//        if (start == end) {
//            return null;
//        }
//        ListNode fast = start;
//        ListNode slow = start;
//        while (fast != end && fast.next != end) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//
//        MyTreeNode root = new MyTreeNode(slow.val);
//        root.left = createTree(start, slow);
//        root.right = createTree(slow.next, end);
//
//        return root;
//    }

    public static void preOrder(MyTreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class MyTreeNode {
    int val;
    MyTreeNode left;
    MyTreeNode right;

    public MyTreeNode(int val, MyTreeNode left, MyTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public MyTreeNode() {
    }

    public MyTreeNode(int val) {
        this.val = val;
    }

    public MyTreeNode(String val) {
        this.val = Integer.parseInt(val);
    }
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

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}