
/**
 * @author CuiJunJie
 * @create 2020-11-04-11:15
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] vals = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeNode.createTree(vals, 0);
        TreeNode root2 = invertTree(root);
        TreeNode.levelOrder(root2);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }
}
