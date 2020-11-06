import javax.sql.rowset.serial.SerialArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-11-06-11:23
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] vals = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeNode.createTree(vals, 0);
        TreeNode node = lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
        System.out.println(node.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left == null && right == null) {
            return null;
        } else if (left == null && right != null) {
            return right;
        } else {
            return left;
        }
    }

//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<TreeNode> path1 = new ArrayList<>();
//        getPath(root, p, path1);
//        List<TreeNode> path2 = new ArrayList<>();
//        getPath(root, q, path2);
//
//        Collections.reverse(path1);
//        Collections.reverse(path2);
//
//        TreeNode node = null;
//        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
//            if (path1.get(i) == path2.get(i)) {
//                node = path1.get(i);
//            } else {
//                break;
//            }
//        }
//
//        return node;
//    }

    public static boolean getPath(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        if (root.val == node.val) {
            path.add(root);
            return true;
        }
        if (getPath(root.left, node, path)) {
            path.add(root);
            return true;
        }
        if (getPath(root.right, node, path)) {
            path.add(root);
            return true;
        }

        return false;
    }
}
