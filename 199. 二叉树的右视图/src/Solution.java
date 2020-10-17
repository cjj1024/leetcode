import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author CuiJunJie
 * @create 2020-10-17-15:06
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] vals = {1,2,3,null,5,null,4};
        TreeNode root = TreeNode.createTree(vals, 0);

        List<Integer> ret = rightSideView(root);
        for (Integer v : ret) {
            System.out.println(v);
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            ret.add(root.val);
        }
        return ret;
    }
}
