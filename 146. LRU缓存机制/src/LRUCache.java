import com.sun.corba.se.pept.encoding.InputObject;

/**
 * @author CuiJunJie
 * @create 2020-09-18-14:18
 */
public class LRUCache {

    private int capacity;
    private int length;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = head;

        length = 0;
    }

    public int get(int key) {
        ListNode node = getPreNode(key);

        if (node != null) {
            int value = node.next.val;
            tail.next = node.next;
            tail = tail.next;
            node.next = node.next.next;
            tail.next = null;
            return value;
        }

        return -1;
    }

    public ListNode getPreNode(int key) {
        ListNode node = head;
        while (node.next != null) {
            if (node.next.key == key) {
                return node;
            }
            node = node.next;
        }

        return null;
    }

    public void put(int key, int value) {
        ListNode node = getPreNode(key);
        if (node == null) {
            if (length >= capacity) {
                head.next = head.next.next;
                if (head.next == null) {
                    tail = head;
                }
                length--;
            }
            tail.next = new ListNode(key, value);
            tail = tail.next;
            length++;
        } else {
            node.next.val = value;
            tail.next = node.next;
            tail = tail.next;
            node.next = node.next.next;
            tail.next = null;
        }
    }
}

class ListNode {
    int key;
    int val;
    ListNode next;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}