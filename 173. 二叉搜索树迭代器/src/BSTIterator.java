import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2020-09-26-11:01
 */
class BSTIterator {

    private TreeNode root;
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        this.root = root;
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;

        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

