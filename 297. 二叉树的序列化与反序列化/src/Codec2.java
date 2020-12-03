/**
 * @author CuiJunJie
 * @create 2020/12/3-14:41
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            sb.append(root.val + ",");
            root = root.left;
        }
        sb.append("null,");
        while (!stack.isEmpty()) {
            root = stack.pop();

            if (root.right != null) {
                sb.append(root.right.val + ",");
                stack.push(root.right);
                root = root.right;
                while (root.left != null) {
                    sb.append(root.left.val + ",");
                    stack.push(root.left);
                    root = root.left;
                }
                sb.append("null,");
            } else {
                sb.append("null,");
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
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < vals.length; i++) {
            queue.offer(vals[i]);
        }
        TreeNode root = createTree(queue);
        return root;
    }

    private TreeNode createTree(Queue<String> queue) {
        if (queue.isEmpty() || queue.peek().equals("null")) {
            if (!queue.isEmpty()) {
                queue.poll();
            }
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(queue.peek()));
        queue.poll();
        root.left = createTree(queue);
        root.right = createTree(queue);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));