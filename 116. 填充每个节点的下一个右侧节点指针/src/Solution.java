import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CuiJunJie
 * @create 2020-08-31-16:28
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7};

        Node tree = createTree(nums, 0);
        connect(tree);
        preOrder(tree);

    }

    public static Node connect(Node root) {
        if (root == null || root.left == null || root.right == null) {
            return root;
        }

        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

//    public static Node connect(Node root) {
//        if (root == null) {
//            return root;
//        }
//
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            Node left = queue.poll();
//            int size = queue.size();
//            if (left.left != null) {
//                queue.offer(left.left);
//            }
//            if (left.right != null) {
//                queue.offer(left.right);
//            }
//            for (int i = 0; i < size; i++) {
//                Node right = queue.poll();
//                left.next = right;
//                left = right;
//                if (right.left != null) {
//                    queue.offer(right.left);
//                }
//                if (right.right != null) {
//                    queue.offer(right.right);
//                }
//            }
//        }
//
//        return root;
//    }

    public static Node createTree(Integer[] arr, int i) {
        if (i >= arr.length || arr[i] == null) {
            return null;
        }
        Node root = new Node(arr[i]);
        root.left = createTree(arr, 2 * i + 1);
        root.right = createTree(arr, 2 * i + 2);

        return root;
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node next;

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public Node(int val) {
        this.val = val;
    }
}