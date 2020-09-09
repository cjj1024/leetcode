import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2020-09-09-15:21
 */
public class Solution {
    public static void main(String[] args)  {
        Integer[] nums = {4,9,null,5,1};
        MyTreeNode tree = createTree(nums, 0);
        System.out.println(sumNumbers(tree));
    }


    public static int sumNumbers(MyTreeNode root) {
        if (root == null) {
            return 0;
        }

        return sumNumbers(root, root.val);
    }

    public static int sumNumbers(MyTreeNode root, int val) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return val;
        }
        int sum = 0;
        if (root.left != null) {
            sum += sumNumbers(root.left, val * 10 + root.left.val);
        }
        if (root.right != null) {
            sum += sumNumbers(root.right, val * 10 + root.right.val);
        }
        return sum;
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
