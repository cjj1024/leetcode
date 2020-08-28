import javax.swing.tree.TreeNode;

/**
 * @author CuiJunJie
 * @create 2020-08-28-16:01
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1};
        MyTreeNode tree = createTree(nums, 0);

        System.out.println(hasPathSum(tree, 22));
    }

    public static boolean hasPathSum(MyTreeNode root, int sum) {
        return hasPathSum(root, sum, 0);
    }

    public static boolean hasPathSum(MyTreeNode root, int sum, int k) {
        if (root == null) {
            return false;
        }
        if (root.val + k == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum, root.val + k) || hasPathSum(root.right, sum, root.val + k);
    }

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
