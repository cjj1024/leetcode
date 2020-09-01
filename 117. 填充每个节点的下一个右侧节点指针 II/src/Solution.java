import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author CuiJunJie
 * @create 2020-08-31-16:51
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,null,7};
        Node tree = createTree(nums, 0);

        connect(tree);
    }

    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node head = root;
        Node node;
        while (head != null) {
            Node level = new Node();
            node = level;
            while (head != null) {
                if (head.left != null) {
                    node.next = head.left;
                    node = node.next;
                }
                if (head.right != null){
                    node.next = head.right;
                    node = node.next;
                }
                head = head.next;
            }
            head = level.next;
        }

        return root;
    }

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

    public Node() {
    }
}