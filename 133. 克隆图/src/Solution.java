import javax.security.auth.kerberos.KerberosTicket;
import java.util.*;
import java.util.function.DoubleToIntFunction;

/**
 * @author CuiJunJie
 * @create 2020-09-11-9:22
 */
public class Solution {
    public static void main(String[] args) {
        int[][] adjList = {
                {2, 4},
                {1, 3},
                {2, 4},
                {1, 3}
        };

        Node node = createGraph(adjList);
        Node node1 = cloneGraph(node);
        System.out.println("end");
    }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Node tmp = node;
        Map<Node, Node> map = new HashMap<Node, Node>();
        map.put(node, new Node(node.val));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            for (Node neighbor : node.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                map.get(node).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(tmp);
    }

//    public static Node cloneGraph(Node node) {
//        if (node == null) {
//            return null;
//        }
//        if (node.neighbors == null) {
//            return new Node(node.val);
//        }
//        Map<Integer, Node> ret = new HashMap<Integer, Node>();
//        List<Node> used = new ArrayList<>();
//        Queue<Node> queue = new LinkedList<Node>();
//        queue.offer(node);
//        ret.put(node.val, new Node(node.val));
//        while (!queue.isEmpty()) {
//            node = queue.poll();
//            if (used.contains(node)) {
//                continue;
//            }
//            used.add(node);
//            for (Node neighbor : node.neighbors) {
//                if (!ret.containsKey(neighbor.val)) {
//                    ret.put(neighbor.val, new Node(neighbor.val));
//                }
//                ret.get(node.val).neighbors.add(ret.get(neighbor.val));
//                queue.offer(neighbor);
//            }
//        }
//
//        return ret.get(1);
//    }

    public static Node createGraph(int[][] adjList) {
        if (adjList.length == 0) {
            return null;
        }
        if (adjList.length == 1 && adjList[0].length == 0) {
            return new Node(1);
        }

        int nodeNum = adjList.length;
        for (int[] ints : adjList) {
            for (int anInt : ints) {
                nodeNum = Math.max(nodeNum, anInt);
            }
        }
        List<Node> nodes = new ArrayList<>(nodeNum);
        for (int i = 1; i <= nodeNum; i++) {
            nodes.add(new Node(i));
        }
        for (int i = 0; i < adjList.length; i++) {
            for (int j = 0; j < adjList[i].length; j++) {
                nodes.get(i).addAdj(nodes.get(adjList[i][j] - 1));
            }
        }

        return nodes.get(0);
    }
}


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public void addAdj(Node adj) {
        neighbors.add(adj);
    }
}
