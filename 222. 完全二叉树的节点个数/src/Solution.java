import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CuiJunJie
 * @create 2020-11-03-15:49
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, 4, 5, 6, null};

        TreeNode root = TreeNode.createTree(vals, 0);
        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }

    private static int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth += 1;
            root = root.left;
        }

        return depth;
    }

//    public static int countNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int count = 1;
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node.left != null) {
//                queue.offer(node.left);
//                count += 1;
//            }
//            if (node.right != null) {
//                queue.offer(node.right);
//                count += 1;
//            }
//        }
//
//        return count;
//    }
}
