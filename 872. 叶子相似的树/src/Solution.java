import java.util.*;

/**
 * @author CuiJunJie
 * @create 2021/5/10-9:54
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.createTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4, null, null, null, null}, 0);
        TreeNode tree2 = TreeNode.createTree(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8}, 0);
        System.out.println(leafSimilar(tree1, tree2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = getLeaves(root1);
        List<Integer> leaves2 = getLeaves(root2);

        if (leaves1.size() != leaves2.size()) {
            return false;
        }

        for (int i = 0; i < leaves1.size(); i++) {
            if  (leaves1.get(i) != leaves2.get(i)) {
                return false;
            }
        }

        return true;
    }

    public static List<Integer> getLeaves(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode node = root;
        stack.push(node);
        while (node.left != null) {
            stack.push(node.left);
            node = node.left;
        }
        while (!stack.isEmpty()) {
            node = stack.poll();
            if (node.left == null && node.right == null) {
                leaves.add(node.val);
            }
            if (node.right != null) {
                stack.push(node.right);
                node = node.right;
                while (node.left != null) {
                    stack.push(node.left);
                    node = node.left;
                }
            }
        }

        return leaves;
    }
}
