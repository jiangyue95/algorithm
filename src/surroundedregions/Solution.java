// LeetCode 130. Surrounded Regions
package surroundedregions;

import basicdatastructure.UF;

public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        // reserve an extra position for dummy
        UF uf = new UF(m * n + 1);
        int dummy = m * n;
        // make the 'O' in first column and last column connect dummy
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(i * n, dummy);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(i * n + n - 1, dummy);
            }
        }

        // make the 'O' in the first row and last row connect dummy
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                uf.union(j, dummy);
            }
            if (board[m - 1][j] == 'O') {
                uf.union(n * (m - 1) + j, dummy);
            }
        }

        // direction array d is a common way to search horizontally or vertically.
        int[][] d = new int[][] {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    // connect this 'O' with the 'O' in the horizontal and verical position
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'O') {
                            uf.union(x * n + y, i * n + j);
                        }
                    }
                }
            }
        }
        
        // all 'O' don not connect with dummy need to be replace with 'X'
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!uf.connected(dummy, i * n + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
