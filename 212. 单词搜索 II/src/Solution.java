import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-10-23-14:40
 */
public class Solution {
    public static void main(String[] args) {
//        String[] words = {"oath","pea","eat","rain"};
//        char[][] board = {
//                {'o','a','a','n'},
//                {'e','t','a','e'},
//                {'i','h','k','r'},
//                {'i','f','l','v'}
//        };
        String[] words = {"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"};
        char[][] board = {
                {'a', 'b', 'c'},
                {'a', 'e', 'd'},
                {'a', 'f', 'g'}
        };

        List<String> words1 = findWords(board, words);
        words1.forEach(System.out::println);
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> ret = new ArrayList<>();
        for (String word : words) {
            if (search(board, word)) {
                ret.add(word);
            }
        }

        return ret;
    }

    private static boolean search(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (dfs(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int k) {
        if (i < 0 || j < 0) {
            return false;
        }
        if (i >= board.length || j >= board[0].length) {
            return false;
        }

        if (visited[i][j]) {
            return false;
        }

        if (board[i][j] == word.charAt(k)) {
            if (k == word.length() - 1) {
                return true;
            }
            visited[i][j] = true;
            if (dfs(board, visited, word, i + 1, j, k + 1)) {
                return true;
            }
            if (dfs(board, visited, word, i - 1, j, k + 1)) {
                return true;
            }
            if (dfs(board, visited, word, i, j + 1, k + 1)) {
                return true;
            }
            if (dfs(board, visited, word, i, j - 1, k + 1)) {
                return true;
            }
            visited[i][j] = false;
        }

        return false;
    }
}
