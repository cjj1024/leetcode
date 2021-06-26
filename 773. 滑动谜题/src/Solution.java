import java.util.*;

/**
 * @author CuiJunJie
 * @create 2021/6/26-10:05
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}}));
    }

    private static int[][] move = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
    public static int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append((char) ('0' + board[i][j]));
            }
        }

        if ("123450".equals(sb.toString())) {
            return 0;
        }

        Set<String> seen = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(sb.toString());
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String state = queue.poll();
                for (String nextState : getNextState(state)) {
                    if (seen.contains(nextState)) {
                        continue;
                    }
                    if ("123450".equals(nextState)) {
                        return step;
                    }
                    seen.add(nextState);
                    queue.offer(nextState);
                }
            }
        }

        return -1;
    }

    private static List<String> getNextState(String state) {
        char[] s = state.toCharArray();
        List<String> nextState = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '0') {
                for (int j = 0; j < move[i].length; j++) {
                    char t;
                    t = s[i];
                    s[i] = s[move[i][j]];
                    s[move[i][j]] = t;
                    nextState.add(String.valueOf(s));
                    t = s[i];
                    s[i] = s[move[i][j]];
                    s[move[i][j]] = t;
                }
            }
        }

        return nextState;
    }
}
