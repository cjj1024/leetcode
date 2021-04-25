import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author CuiJunJie
 * @create 2021/4/25-14:17
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{5, 3, 6, 2, 4, null, 8, 1, null, null, null, null, null, 7, 9}, 0);
//        TreeNode tree = TreeNode.createTree(new Integer[]{2, 1, 4, null, null, 3, null}, 0);
//        TreeNode tree = TreeNode.createTree(new Integer[]{106, null, 783}, 0);
        tree = increasingBST(tree);
        TreeNode.levelOrder(tree);
    }

    public static TreeNode increasingBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (root.left != null) {
            stack.addLast(root.left);
            root = root.left;
        }

        root = new TreeNode(-1);;
        TreeNode pre = root;
        TreeNode now = pre;
        while (!stack.isEmpty()) {
            now = stack.removeLast();
            pre.left = null;
            pre.right = now;
            pre = now;

//            System.out.println(now.val);
            if (now.right != null) {
                stack.addLast(now.right);
                now = now.right;
                while (now.left != null) {
                    stack.addLast(now.left);
                    now = now.left;
                }
            }
        }
        now.left = null;
        now.right = null;

        return root.right;
    }
}
