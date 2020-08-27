import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2020-08-25-17:09
 */
public class Solution {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        MyTreeNode tree = buildTree(preorder, inorder);
        preOrder(tree);
    }

    public static MyTreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1 || inorder.length < 1 || preorder.length != inorder.length) {
            return null;
        }
        Stack<MyTreeNode> stack = new Stack<>();
        MyTreeNode root = new MyTreeNode(preorder[0]);
        stack.push(root);
        int index = 0;
        for (int i = 1; i < preorder.length; i++) {
            MyTreeNode node = new MyTreeNode(preorder[i]);
            if (stack.peek().val != inorder[index]) {
                stack.peek().left = node;
            } else {
                MyTreeNode pre = null;
                while (!stack.empty() && stack.peek().val == inorder[index]) {
                    pre = stack.pop();
                    index++;
                }
                pre.right = node;
            }
            stack.push(node);
        }
        return root;
    }

//    public static MyTreeNode buildTree(int[] preorder, int[] inorder) {
//        Map<Integer, Integer> index = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            index.put(inorder[i], i);
//        }
//
//        return buildTree(index, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
//    }
//
//    public static MyTreeNode buildTree(Map<Integer, Integer> index, int[] preorder, int preorderLeft, int preorderRight,
//                                       int[] inorder, int inorderLeft, int inorderRight) {
//        if (preorderLeft > preorderRight) {
//            return null;
//        }
//        MyTreeNode root = new MyTreeNode(preorder[preorderLeft]);
//        int leftSize = index.get(preorder[preorderLeft]) - inorderLeft;
//        root.left = buildTree(index, preorder, preorderLeft + 1, preorderLeft + leftSize,
//                inorder, inorderLeft, inorderLeft + leftSize);
//        root.right = buildTree(index, preorder, preorderLeft + leftSize + 1, preorderRight,
//                inorder, inorderLeft + leftSize + 1, inorderRight);
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

    public MyTreeNode(int val) {
        this.val = val;
    }

    public MyTreeNode(String val) {
        this.val = Integer.parseInt(val);
    }
}