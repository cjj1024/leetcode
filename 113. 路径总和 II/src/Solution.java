import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-08-28-16:13
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1};
        MyTreeNode tree = createTree(nums, 0);

        List<List<Integer>> lists = pathSum(tree, 22);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.printf("%d ", integer);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> pathSum(MyTreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }

        List<Integer> list = new ArrayList<>();

        pathSum(root, sum, 0, lists, list);
        return lists;
    }

    public static void pathSum(MyTreeNode root, int sum, int k, List<List<Integer>> lists, List<Integer> list) {
        list.add(root.val);
        if (root.val + k == sum && root.left == null && root.right == null) {
            lists.add(new ArrayList<>(list));
        }
        if (root.left != null) {
            pathSum(root.left, sum, k + root.val, lists, list);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            pathSum(root.right, sum, k + root.val, lists, list);
            list.remove(list.size() - 1);
        }
    }

    public static MyTreeNode createTree(Integer[] arr, int i) {
        if (i >= arr.length || arr[i] == null) {
            return null;
        }
        MyTreeNode root = new MyTreeNode(arr[i]);
        root.left = createTree(arr, 2 * i + 1);
        root.right = createTree(arr, 2 * i + 2);

        return root;
    }

    public static void preOrder(MyTreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
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

    public MyTreeNode(int val, MyTreeNode left, MyTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public MyTreeNode() {
    }

    public MyTreeNode(int val) {
        this.val = val;
    }

    public MyTreeNode(String val) {
        this.val = Integer.parseInt(val);
    }
}
