import java.util.HashMap;

/**
 * @author CuiJunJie
 * @create 2021/8/9-16:16
 */
public class LRUCache {
    class Node {
        public int key;
        public int value;
        public Node before;
        public Node after;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }


        public Node() {
        }
    }

    private HashMap<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this();
        this.capacity = capacity;
    }

    public LRUCache() {
        cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.after = tail;
        tail.before = head;
    }


    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        moveToTail(node);

        return node.value;
    }

    private void moveToTail(Node node) {
        removeNode(node);
        addToTail(node);
    }

    private void removeNode(Node node) {
        Node before = node.before;

        before.after = node.after;
        node.after.before = before;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToTail(node);
            return;
        }

        if (cache.size() == capacity) {
            removeEldestEntry();
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        addToTail(node);
    }

    private void addToTail(Node node) {
        Node before = tail.before;

        node.after = tail;
        node.before = before;
        before.after = node;
        tail.before = node;
    }

    private void removeEldestEntry() {
        Node eldestEntry = head.after;
        cache.remove(eldestEntry.key);
        head.after.after.before = head;
        head.after = head.after.after;
    }

}
