import com.sun.scenario.animation.shared.TimerReceiver;
import sun.text.normalizer.Trie;

/**
 * @author CuiJunJie
 * @create 2020-10-23-11:01
 */
public class WordDictionary {

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (!node.contains(c)) {
                node.put(c);
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, TrieNode node) {
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (c == '.') {
                boolean valid = false;
                for (char c1 = 'a'; c1 <= 'z'; c1++) {
                    if (node.contains(c1)) {
                        valid = valid | search(word.substring(word.indexOf(c) + 1), node.get(c1));
                    }
                }

                return valid;
            }
            if (node.contains(c)) {
                node = node.get(c);
            } else {
                return false;
            }
        }

        if (node.isEnd()) {
            return true;
        }

        return false;
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
        links[c - 'a'] = new TrieNode();
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public boolean contains(char c) {
        return links[c - 'a'] != null;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }
}