import javax.swing.tree.TreeNode;

/**
 * @author CuiJunJie
 * @create 2020-08-28-10:08
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        MyTreeNode tree = sortedArrayToBST(nums);
        preOrder(tree);
    }

    public static MyTreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }

        return createTree(nums, 0, nums.length - 1);
    }

    public static MyTreeNode createTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end + 1) >> 1;
        MyTreeNode root = new MyTreeNode(nums[mid]);
        root.left = createTree(nums, start, mid - 1);
        root.right = createTree(nums, mid + 1, end);

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

    public MyTreeNode(int val) {
        this.val = val;
    }

    public MyTreeNode(String val) {
        this.val = Integer.parseInt(val);
    }
}