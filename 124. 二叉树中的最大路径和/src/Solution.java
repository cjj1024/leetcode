import javax.swing.tree.TreeNode;

/**
 * @author CuiJunJie
 * @create 2020-09-04-11:01
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] vals = {2, -1};
        MyTreeNode root = createTree(vals, 0);
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(MyTreeNode root) {
        if (root == null) {
            return 0;
        }

        maxGain(root);
       return maxPathSumVal;
    }

    public static int maxPathSumVal = Integer.MIN_VALUE;
    public static int maxGain(MyTreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftGain = Math.max(0, maxGain(root.left));
        int rightGain = Math.max(0, maxGain(root.right));

        maxPathSumVal = Math.max(maxPathSumVal, root.val + leftGain + rightGain);

        return root.val + Math.max(leftGain, rightGain);
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
