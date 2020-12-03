/**
 * @author CuiJunJie
 * @create 2020/12/3-11:24
 */
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (flag && !queue.isEmpty()) {
            flag = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root != null) {
                    flag = true;
                    sb.append(root.val + ",");
                    queue.offer(root.left);
                    queue.offer(root.right);
                } else {
                    sb.append("null,");
                    queue.offer(null);
                    queue.offer(null);
                }
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 1) {
            return null;
        }

        String[] vals = data.split(",");
        TreeNode root = createTree(vals, 0);
        return root;
    }

    public TreeNode createTree(String[] vals, int i) {
        if (i >= vals.length || "null".equals(vals[i])) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(vals[i]));
        root.left = createTree(vals, 2 * i + 1);
        root.right = createTree(vals, 2 * i + 2);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));