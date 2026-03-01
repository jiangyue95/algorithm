package nqueens;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solution = solveNQueens(n);
        System.out.println("N-queens solution: " + solution);
    }

    // main method
    public static List<List<String>> solveNQueens(int n) {
        // use a two-demensional array res to store the result
        List<List<String>> res = new ArrayList<>();
        // initialize a two-demensional char board
        char[][] board = new char[n][n];

        // set the board into empty
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // invert backtrack method
        backtrack(board, 0, res);
        return res;
    }

    // backtrack method
    public static void backtrack(char[][] board, int row, List<List<String>> res) {
        // baseline case
        if (row == board.length) { // row reach the end of board
            res.add(construct(board)); // store the outcome into res
            return;
        }

        // get the column of board
        int n = board.length;
        // check whether each position is suitable
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) { // if it is valid skip this position
                continue;
            }
            // set current position has a queen
            board[row][col] = 'Q';
            // check next row
            backtrack(board, row + 1, res);
            // backtracking operation
            board[row][col] = '.';
        }
    }


    // tool method check current postion
    private static boolean isValid(char[][] board, int row, int col) {
        int n = board.length;

        // check the current column
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // check the left-up diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // check the right-up digonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // tool method: transfer the type of char[][] into the type of List<String>
    private static List<String> construct(char[][] board) {
        List<String> sol = new ArrayList<>();
        for (char[] r : board) {
            sol.add(String.valueOf(r));
        }
        return sol;
    }
}
