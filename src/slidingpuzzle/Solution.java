// LeetCode 773. Sliding Puzzle
package slidingpuzzle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int slidingPuzzle(int[][] board) {
        int m = 2;
        int n = 3;
        StringBuilder sb = new StringBuilder();
        String target = "123450";

        // transfer the 2 x 3 2-D array into a string as the start of BFS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();

        // record the 1-d array's adjacent index
        int[][] neighbor = new int[][] {{1, 3}, {0, 4, 2}, {1, 5}, {0, 4}, {3, 1, 5}, {4, 2}};

        /* Begin the template of BFS algorithm */
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        // begin the BFS from start
        q.offer(start);
        visited.add(start);

        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                // check if it reaches the target condition
                if (target.equals(cur)) {
                    return step;
                }
                // find the index of number 0
                int idx = 0;
                while (cur.charAt(idx) != '0') {
                    idx++;
                }
                // change the position of the number 0 and its adjacent number
                for (int adj : neighbor[idx]) {
                    String new_board = swap(cur.toCharArray(), adj, idx);
                    // prevent move backwards
                    if (!visited.contains(new_board)) {
                        q.offer(new_board);
                        visited.add(new_board);
                    }
                }
            }
            step++;
        }
        /* End the template of BFS algorithm */
        return -1;
    }

    private String swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
