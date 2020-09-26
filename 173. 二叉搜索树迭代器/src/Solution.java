/**
 * @author CuiJunJie
 * @create 2020-09-26-11:01
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] val = {7, 3, 15, null, null, 9, 20};

        TreeNode root = TreeNode.createTree(val, 0);

//        BSTIterator iterator = new BSTIterator(root);
//        iterator.next();    // 返回 3
//        iterator.next();    // 返回 7
//        iterator.hasNext(); // 返回 true
//        iterator.next();    // 返回 9
//        iterator.hasNext(); // 返回 true
//        iterator.next();    // 返回 15
//        iterator.hasNext(); // 返回 true
//        iterator.next();    // 返回 20
//        iterator.hasNext(); // 返回 false


        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }


}
