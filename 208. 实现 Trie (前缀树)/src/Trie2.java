/**
 * @author CuiJunJie
 * @create 2021/4/14-9:36
 */
class Trie2 {

    private class Node {
        public Node[] next;
        public boolean isEnd;

        public Node() {
            next = new Node[26];
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public Trie2() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        char[] cstr = word.toCharArray();
        for (int i = 0; i < cstr.length; i++) {
            int index = cstr[i] - 'a';
            if (node.next[index] == null) {
                node.next[index] = new Node();
            }
            node = node.next[index];
        }

        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        char[] cstr = word.toCharArray();
        for (int i = 0; i < cstr.length; i++) {
            int index = cstr[i] - 'a';
            if (node.next[index] == null) {
                return false;
            }
            node = node.next[index];
        }

        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        char[] cstr = prefix.toCharArray();
        for (int i = 0; i < cstr.length; i++) {
            int index = cstr[i] - 'a';
            if (node.next[index] == null) {
                return false;
            }
            node = node.next[index];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
