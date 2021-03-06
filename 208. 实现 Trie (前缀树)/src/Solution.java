/**
 * @author CuiJunJie
 * @create 2020-10-22-11:18
 */
public class Solution {
    public static void main(String[] args) {
        Trie2 trie = new Trie2();

//        trie.insert("apple");
//        trie.search("apple");   // 返回 true
//        trie.search("app");     // 返回 false
//        trie.startsWith("app"); // 返回 true
//        trie.insert("app");
//        trie.search("app");     // 返回 true

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

//        trie.insert("abp");
//        trie.insert("acpde");
//        System.out.println(trie.search("abp"));
//        System.out.println(trie.search("acp"));
    }


}
