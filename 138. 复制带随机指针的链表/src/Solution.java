import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CuiJunJie
 * @create 2020-09-15-17:25
 */
public class Solution {
    public static void main(String[] args) {
        Integer[][] nodes = new Integer[][]{{7,null},{13,0},{11,4},{10,2},{1,0}};
        Node head = createList(nodes);
        Node node = copyRandomList(head);

    }

    private static Node createList(Integer[][] nodes) {
        Map<Integer, Node> map = new HashMap<>();
        for (Integer[] node : nodes) {
            map.put(node[0], new Node(node[0]));
        }

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i][1] != null) {
                map.get(nodes[i][0]).random = map.get(nodes[nodes[i][1]][0]);
            }
        }
        for (int i = 0; i < nodes.length - 1; i++) {
            map.get(nodes[i][0]).next = map.get(nodes[i + 1][0]);
        }

        return map.get(nodes[0][0]);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Map<Node, Node> map = new HashMap<>();

        Node node = head;
        while (node != null) {
            if (!map.containsKey(node)) {
                map.put(node, new Node(node.val));
            }
            if (node.random != null && !map.containsKey(node.random)) {
                map.put(node.random, new Node(node.random.val));
            }
            if (node.next != null && !map.containsKey(node.next)) {
                map.put(node.next, new Node(node.next.val));
            }

            map.get(node).random = map.get(node.random);
            map.get(node).next = map.get(node.next);
            node = node.next;
        }

        return map.get(head);
    }
}


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
