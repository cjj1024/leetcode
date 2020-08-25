import com.sun.jmx.remote.internal.ArrayQueue;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author CuiJunJie
 * @create 2020-08-24-16:04
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        MyTreeNode tree = createTree(nums, 0);

        List<List<Integer>> lists = levelOrder(tree);
        for (List<Integer> list : lists) {
            list.forEach(System.out::print);
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrder(MyTreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list;
        while (!queue.isEmpty()) {
            list = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.peek();
                list.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
                queue.poll();
            }

            ret.add(list);
        }

        return ret;
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