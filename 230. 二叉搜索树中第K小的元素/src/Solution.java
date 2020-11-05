import javax.xml.crypto.dsig.keyinfo.KeyName;
import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2020-11-05-9:41
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] vals = {3, 1, 4, null, 2};
        TreeNode root = TreeNode.createTree(vals, 0);
        System.out.println(kthSmallest(root, 3));
    }

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.isEmpty()) {
            node = stack.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }

        return -1;
    }
}
