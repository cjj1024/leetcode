/**
 * @author CuiJunJie
 * @create 2020-10-22-11:18
 */
public class Trie {
    private TireNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TireNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TireNode node = root;

        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (!node.containsKey(c)) {
                node.put(c, new TireNode());
            }
            node = node.get(c);
        }

        node.setEnd();
    }

    public TireNode searchPrefix(String word) {
        TireNode node = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }

        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TireNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TireNode node = searchPrefix(prefix);
        return node != null;
    }
}


class TireNode {
    private final int R = 26;
    private TireNode[] links;
    private boolean isEnd;

    public TireNode() {
        links = new TireNode[R];
    }

    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }

    public TireNode get(char c) {
        return links[c - 'a'];
    }

    public void put(char c, TireNode node) {
        links[c - 'a'] = node;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }
}
