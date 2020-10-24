/**
 * @author CuiJunJie
 * @create 2020-10-24-10:38
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            node.put(c);
            node = node.get(c);
        }

        node.setEnd();
    }

    public TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }

        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);

        return node != null && node.isEnd();
    }

    public boolean startWithPrefix(String prefix) {
        return searchPrefix(prefix) != null;
    }
}


class TrieNode {
    private final static int R = 26;
    private TrieNode[] links;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
        isEnd = false;
    }

    public void put(char c) {
        if (links[c - 'a'] == null) {
            links[c - 'a'] = new TrieNode();
        }
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }
}