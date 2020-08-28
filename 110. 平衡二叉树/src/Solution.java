import javax.swing.tree.TreeNode;

/**
 * @author CuiJunJie
 * @create 2020-08-28-15:24
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] nums = {1,2,2,3,null,null,3,4,null,null,4};
        MyTreeNode tree = createTree(nums, 0);
        System.out.println(isBalanced(tree));
        System.out.println(getLength(tree));
    }

    public static boolean isBalanced(MyTreeNode root) {
        if (root == null) {
            return true;
        }

        return getLength(root) != -1;
    }

    public static int getLength(MyTreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLength = getLength(root.left);
        int rightLength = getLength(root.right);

        if (leftLength == -1 || rightLength == -1 || Math.abs(leftLength - rightLength) > 1) {
            return -1;
        } else {
            return Math.max(leftLength, rightLength) + 1;
        }
    }

//    public static boolean isBalanced(MyTreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        return Math.abs(getLength(root.left) - getLength(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//    }

//    public static int getLength(MyTreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(getLength(root.left), getLength(root.right)) + 1;
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