import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-09-18-11:25
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] vals = {1,null,2,null,null,3};
        MyTreeNode root = MyTreeNode.createTree(vals, 0);
        List<Integer> integers = postorderTraversal(root);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public static List<Integer> postorderTraversal(MyTreeNode root) {
        List<Integer> ret = new ArrayList<>();
        postorder(root, ret);

        return ret;
    }

    private static void postorder(MyTreeNode root, List<Integer> ret) {
        if (root != null) {
            postorder(root.left, ret);
            postorder(root.right, ret);
            ret.add(root.val);
        }
    }
}

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