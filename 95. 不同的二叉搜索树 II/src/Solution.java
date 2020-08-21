import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-08-20-19:07
 */
public class Solution {
    public static void main(String[] args) {
        List<MyTreeNode> myTreeNodes = generateTrees(0);

        for (MyTreeNode myTreeNode : myTreeNodes) {
            InOrder(myTreeNode);
            System.out.println();
        }
    }

    public static List<MyTreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }


        return recursion(nums, 0, nums.length - 1);
    }

    public static List<MyTreeNode> recursion(int[] nums, int start, int end) {
        List<MyTreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }


        for (int i = start; i <= end; i++) {

            List<MyTreeNode> leftsTrees = recursion(nums, start, i - 1);
            List<MyTreeNode> rightTrees = recursion(nums, i + 1, end);
            for (MyTreeNode leftsTree : leftsTrees) {
                for (MyTreeNode rightTree : rightTrees) {
                    MyTreeNode root = new MyTreeNode(nums[i]);
                    root.left = leftsTree;
                    root.right = rightTree;
                    allTrees.add(root);
                }
            }
        }

        return allTrees;
    }

    public static void InOrder(MyTreeNode root) {
        if (root != null) {
            System.out.printf("%d ", root.val);
            InOrder(root.left);
            InOrder(root.right);
        } else {
            System.out.printf("%s ", "null");
        }
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class MyTreeNode {
    int val;
    MyTreeNode left;
    MyTreeNode right;

    public MyTreeNode(int val) {
        this.val = val;
    }

    public MyTreeNode(int val, MyTreeNode left, MyTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public MyTreeNode() {
    }
}