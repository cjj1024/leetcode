
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-11-09-15:22
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, null, 5};
        TreeNode root = TreeNode.createTree(vals, 0);
        List<String> list = binaryTreePaths(root);
        list.forEach(System.out::println);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        find(root, paths, new ArrayList<>());

        return paths;
    }

    private static void find(TreeNode root, List<String> paths, List<String> list) {
        if (root == null) {
            return;
        }

        list.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            paths.add(String.join("->", list));
            list.remove(list.size() - 1);
            return;
        }
        if (root.left != null) {
            find(root.left, paths, list);
        }
        if (root.right != null) {
            find(root.right, paths, list);
        }
        list.remove(list.size() - 1);
    }
}
