import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author CuiJunJie
 * @create 2021/5/17-9:21
 */
public class Solution {
    public static void main(String[] args) {

//        System.out.println(isCousins(TreeNode.createTree(new Integer[]{1, 2, 3, 4, null, null, null}, 0), 4, 3));
//        System.out.println(isCousins(TreeNode.createTree(new Integer[]{1, 2, 3, null, 4, null, 5}, 0), 5, 4));
//        System.out.println(isCousins(TreeNode.createTree(new Integer[]{1, 2, 3, null, null, null, 4}, 0), 3, 2));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                set.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (set.contains(x)) {
                if (set.contains(y)) {
                    TreeNode p1 = getParent(root, null, x);
                    TreeNode p2 = getParent(root, null, y);
                    if (p1 == p2) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
        }

        return false;
    }

    private static TreeNode getParent(TreeNode node, TreeNode parent, int x) {
        if (node.val == x) {
            return parent;
        }

        TreeNode p = null;
        if (node.left != null) {
            if ((p = getParent(node.left, node, x)) != null) {
                return p;
            }
        }
        if (node.right != null) {
            if ((p = getParent(node.right, node, x)) != null) {
                return p;
            }
        }

        return null;
    }
}
