import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-11-06-10:04
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] vals = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = TreeNode.createTree(vals, 0);
        TreeNode node = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        System.out.println(node.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        return getPath(root, p, q);
    }

    private static TreeNode getPath(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {
            return getPath(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return getPath(root.right, p, q);
        } else {
            return root;
        }
    }

//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) {
//            return null;
//        }
//
//        List<TreeNode> path1 = new ArrayList<>();
//        getPath(root, p, path1);
//        List<TreeNode> path2 = new ArrayList<>();
//        getPath(root, q, path2);
//
//        TreeNode ret = null;
//        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
//            if (path1.get(i) == path2.get(i)) {
//                ret = path1.get(i);
//            } else {
//                break;
//            }
//        }
//
//        return ret;
//    }
//
//    private static void getPath(TreeNode root, TreeNode node, List<TreeNode> path) {
//        if (root == null) {
//            return;
//        }
//
//        path.add(root);
//        if (node.val < root.val) {
//            getPath(root.left, node, path);
//        } else if (node.val > root.val) {
//            getPath(root.right, node, path);
//        }
//    }
}
