import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-08-22-16:07
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] arr = {1,3,null,null,2};
        MyTreeNode tree = createTree(arr, 0);
        recoverTree(tree);
        preOrder(tree);
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

    public static void recoverTree(MyTreeNode root) {
        if (root == null) {
            return;
        }

        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int[] swapped = findSwapped(nums);
        recover(root, swapped, 0);
    }

    public static void recover(MyTreeNode root, int[] swapped, int idx) {
        if (root != null) {
            if (root.val == swapped[0] || root.val == swapped[1]) {
                root.val = root.val == swapped[0] ? swapped[1] : swapped[0];
                idx++;
            }
            if (idx == 2) {
                return;
            }
            recover(root.left, swapped, idx);
            recover(root.right, swapped, idx);
        }
    }

    public static int[] findSwapped(List<Integer> nums) {
        int x = -1;
        int y = -1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }

        return new int[] {x, y};
    }

    public static void inOrder(MyTreeNode root, List<Integer> nums) {
        if (root != null) {
            inOrder(root.left, nums);
            nums.add(root.val);
            inOrder(root.right, nums);
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

    public MyTreeNode(int val) {
        this.val = val;
    }

    public MyTreeNode(String val) {
        this.val = Integer.parseInt(val);
    }
}