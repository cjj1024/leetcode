import javax.swing.tree.TreeNode;

/**
 * @author CuiJunJie
 * @create 2020-08-28-15:45
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] nums = {1, 2};
        MyTreeNode tree = createTree(nums, 0);
        System.out.println(minDepth(tree));
    }

    public static int minDepth(MyTreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else{
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
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
