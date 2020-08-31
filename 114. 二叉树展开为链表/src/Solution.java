import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2020-08-28-16:37
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] nums = {1,2,5,3,4,null,6};
        MyTreeNode tree = createTree(nums, 0);
        flatten(tree);

        for (MyTreeNode node = tree; node != null; node = node.right) {
            System.out.println(node.val);
        }
    }

    public static void flatten(MyTreeNode root) {
        if (root == null) {
            return;
        }

        MyTreeNode right;
        MyTreeNode next;
        while (root != null) {
            if (root.left != null) {
                right = root.left;
                next = right;
                while (right.right != null) {
                    right = right.right;
                }
                right.right = root.right;
                root.left = null;
                root.right = next;
            }
            root = root.right;
        }
    }

//    public static void flatten(MyTreeNode root) {
//        if (root == null || (root.left == null && root.right == null)) {
//            return;
//        }
//
//        Stack<MyTreeNode> stack = new Stack<>();
//        MyTreeNode pre = root;
//        if (root.right != null) {
//            stack.push(root.right);
//        }
//        if (root.left != null) {
//            stack.push(root.left);
//        }
//        while (!stack.isEmpty()) {
//            root = stack.pop();
//            pre.left = null;
//            pre.right = root;
//            pre = root;
//            if (root.right != null) {
//                stack.push(root.right);
//            }
//            if (root.left != null) {
//                stack.push(root.left);
//            }
//        }
//    }

    public static MyTreeNode createTree(Integer[] arr, int i) {
        if (i >= arr.length || arr[i] == null) {
            return null;
        }
        MyTreeNode root = new MyTreeNode(arr[i]);
        root.left = createTree(arr, 2 * i + 1);
        root.right = createTree(arr, 2 * i + 2);

        return root;
    }

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
