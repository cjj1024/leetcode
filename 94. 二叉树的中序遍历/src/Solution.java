import jdk.nashorn.internal.ir.BinaryNode;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-08-20-18:52
 */
public class Solution {
    public static void main(String[] args) {
        MyTreeNode tree = new MyTreeNode(1);

    }

    public List<Integer> inorderTraversal(MyTreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        recursion(root, ret);

        return ret;
    }

    public static void recursion(MyTreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }

        recursion(root.left, ret);
        ret.add(root.val);
        recursion(root.right, ret);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class MyTreeNode {
    int val;
    MyTreeNode left;
    MyTreeNode right;

    public MyTreeNode(int val) {
        this.val = val;
    }
}