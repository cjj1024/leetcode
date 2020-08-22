import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2020-08-22-10:03
 */
public class Solution {
    public static void main(String[] args) {
        String[] arr = {"5", "1", "4", "null", "null", "3", "6"};
//        String[] arr = {"2", "1", "3"};
        MyTreeNode tree = createTree(arr, 0);
        System.out.println(isValidBST(tree));
    }

    public static MyTreeNode createTree(String[] arr, int i) {
        if (i >= arr.length || "null".equals(arr[i])) {
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

    public static boolean isValidBST(MyTreeNode root) {
//        return recursion(root, null, null);
        return InOrder(root);
    }

    public static boolean InOrder(MyTreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<MyTreeNode> stack = new Stack<>();

        double preValue = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= preValue) {
                return false;
            }
            preValue = root.val;
            root = root.right;
        }

        return true;
    }

    public static boolean recursion(MyTreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }

        if (lower != null && root.val <= lower) {
            return false;
        }
        if (upper != null && root.val >= upper) {
            return false;
        }

        return recursion(root.left, lower, root.val) && recursion(root.right, root.val, upper);
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class MyTreeNode {
    int val;
    MyTreeNode left;
    MyTreeNode right;

    public MyTreeNode(int val) {
        this.val = val;
    }

    public MyTreeNode(String val) {
        this.val = Integer.parseInt(val);
    }
}