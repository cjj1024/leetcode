import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-10-24-10:47
 */
public class Solution2 {
    public static void main(String[] args) {
        //        String[] words = {"oath","pea","eat","rain"};
//        char[][] board = {
//                {'o','a','a','n'},
//                {'e','t','a','e'},
//                {'i','h','k','r'},
//                {'i','f','l','v'}
//        };
//        String[] words = {"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"};
//        char[][] board = {
//                {'a', 'b', 'c'},
//                {'a', 'e', 'd'},
//                {'a', 'f', 'g'}
//        };

        String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        char[][] board = {
                {'a', 'b'},
                {'a', 'a'}
        };



        List<String> words1 = findWords(board, words);
        words1.forEach(System.out::println);
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                StringBuilder sb = new StringBuilder();
                boolean[][] visited = new boolean[board.length][board[0].length];
                find(board, visited, trie, list, i, j, sb);
            }
        }

        return list;
    }

    private static void find(char[][] board, boolean[][] visited, Trie trie, List<String> list, int i, int j, StringBuilder sb) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }

        sb.append(board[i][j]);
        visited[i][j] = true;
        String str = sb.toString();
        if (trie.startWithPrefix(str)) {
            if (trie.search(str) && !list.contains(str)) {
                list.add(str);
            }
            find(board, visited, trie, list, i, j + 1, sb);
            find(board, visited, trie, list, i, j - 1, sb);
            find(board, visited, trie, list, i + 1, j, sb);
            find(board, visited, trie, list, i - 1, j, sb);
        }

        sb.deleteCharAt(sb.length() - 1);
        visited[i][j] = false;
    }
}
