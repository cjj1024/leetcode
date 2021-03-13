/**
 * @author CuiJunJie
 * @create 2021/3/13-9:39
 */
public class MyHashSet {

    private boolean[] table;

    /** Initialize your data structure here. */
    public MyHashSet() {
        table = new boolean[1000000];
    }

    public void add(int key) {
        table[key] = true;
    }

    public void remove(int key) {
        table[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return table[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
