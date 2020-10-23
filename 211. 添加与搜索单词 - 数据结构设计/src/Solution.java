/**
 * @author CuiJunJie
 * @create 2020-10-23-11:01
 */
public class Solution {
    public static void main(String[] args) {
//        WordDictionary wordDictionary = new WordDictionary();
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("dad");
//        wordDictionary.addWord("mad");
//        wordDictionary.search("pad"); // return False
//        wordDictionary.search("bad"); // return True
//        wordDictionary.search(".ad"); // return True
//        wordDictionary.search("b.."); // return True

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
        System.out.println(wordDictionary.search("..e"));
    }
}
