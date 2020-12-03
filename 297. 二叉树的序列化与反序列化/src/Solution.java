import sun.reflect.generics.tree.Tree;

/**
 * @author CuiJunJie
 * @create 2020/12/3-11:24
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, null, null, 4, 5, null, null, null, null, 6, 7};
        TreeNode tree = TreeNode.createTree(vals, 0);
        Codec2 codec = new Codec2();
        String serialize = codec.serialize(tree);
        System.out.println(serialize);
        TreeNode root = codec.deserialize(serialize);
        TreeNode.levelOrder(root);
    }
}
