import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author CuiJunJie
 * @create 2021/4/13-9:20
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{4, 2, 6, 1, 3}, 0);
        System.out.println(minDiffInBST(tree));

        System.out.println(minDiffInBST(TreeNode.createTree(new Integer[]{1,0,48,null,null,12,49}, 0)));

        System.out.println(minDiffInBST(TreeNode.createTree(new Integer[]{90,69,null,49,89, null, null, null,52, null, null}, 0)));
    }

    public static int minDiffInBST(TreeNode root) {
        pre = Integer.MAX_VALUE;
        minValue = Integer.MAX_VALUE;
        return LDR(root);
    }

    private static int pre = Integer.MAX_VALUE;
    private static int minValue = Integer.MAX_VALUE;

    public static int LDR(TreeNode root) {
        if (root.left != null) {
            minValue = LDR(root.left);
        }
        minValue = Math.min(minValue, Math.abs(root.val - pre));
        pre = root.val;
        if (root.right != null) {
            minValue = LDR(root.right);
        }

        return minValue;
    }


//    public static int minDiffInBST(TreeNode root) {
//        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
//        stack.addLast(root);
//        int minValue = Integer.MAX_VALUE;
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.removeFirst();
//            if (node.left != null) {
//                stack.addLast(node.left);
//            }
//            if (node.right != null) {
//                stack.addLast(node.right);
//            }
//            minValue = getMinValue(node, minValue);
//        }
//
//        return minValue;
//    }
//
//    private static int getMinValue(TreeNode root, int minValue) {
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        if (root.left != null) {
//            stack.addLast(root.left);
//        }
//        if (root.right != null) {
//            stack.addLast(root.right);
//        }
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.removeFirst();
//            minValue = Math.min(minValue, Math.abs(root.val - node.val));
//            if (node.left != null) {
//                stack.addLast(node.left);
//            }
//            if (node.right != null) {
//                stack.addLast(node.right);
//            }
//        }
//
//        return minValue;
//    }
}
