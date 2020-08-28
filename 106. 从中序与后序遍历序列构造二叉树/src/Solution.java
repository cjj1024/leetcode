import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2020-08-27-19:21
 */
public class Solution {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        MyTreeNode tree = buildTree(inorder, postorder);
        preOrder(tree);
    }

    public static MyTreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length < 1 || postorder.length < 1 || inorder.length != postorder.length) {
            return null;
        }

        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }

        return buildTree(index, inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public static MyTreeNode buildTree(Map<Integer, Integer> index, int[] inorder, int inorderLeft, int inorderRight,
                                       int[] postorder, int postorderLeft, int postorderRight) {
        if (inorderLeft > inorderRight) {
            return null;
        }
        MyTreeNode root = new MyTreeNode(postorder[postorderRight]);
        int leftSize = index.get(postorder[postorderRight]) - inorderLeft;
        root.left = buildTree(index, inorder, inorderLeft, inorderLeft + leftSize - 1,
                postorder, postorderLeft, postorderLeft + leftSize - 1);
        root.right = buildTree(index, inorder, inorderLeft + leftSize + 1, inorderRight,
                postorder, postorderLeft + leftSize, postorderRight - 1);

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