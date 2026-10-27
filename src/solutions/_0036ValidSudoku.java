package solutions;

import java.util.HashSet;
import java.util.Set;

public class _0036ValidSudoku {
    static final int sudokuSize = 9;

    public static boolean isValidSudoku(char[][] board) {
        return validateColumns(board) && validateRows(board) && validateSquares(board);
    }

    private static boolean validateRows(char[][] board) {
        Set<Integer> uniqueValue;
        for (int c = 0; c < sudokuSize; c++) {
            uniqueValue = new HashSet<>();
            for (int r = 0; r < sudokuSize; r++) {
                if (board[c][r] != '.')
                    if (!uniqueValue.add(board[c][r] - '0')) return false;
            }
        }
        return true;
    }

    private static boolean validateColumns(char[][] board) {
        Set<Integer> uniqueValue;
        for (int r = 0; r < sudokuSize; r++) {
            uniqueValue = new HashSet<>();
            for (int c = 0; c < sudokuSize; c++) {
                if (board[c][r] != '.')
                    if (!uniqueValue.add(board[c][r] - '0')) return false;
            }
        }
        return true;
    }

    private static boolean validateSquares(char[][] board) {
        for (int r = 0; r < sudokuSize; r += 3) {
            for (int c = 0; c < sudokuSize; c += 3) {
                if (!validateSquare(board, r, c)) return false;
            }
        }
        return true;
    }

    private static boolean validateSquare(char[][] board, int startRow, int startCol) {
        Set<Integer> uniqueValues = new HashSet<>();
        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (board[r][c] != '.') {
                    if (!uniqueValues.add(board[r][c] - '0')) return false;
                }
            }
        }
        return true;
    }

    private boolean oneIteration(char[][] board) {
        boolean[][] rows = new boolean[9][9], cols = new boolean[9][9], boxes = new boolean[9][9];
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                int d = board[r][c] - '1', b = (r / 3) * 3 + c / 3;
                if (rows[r][d] || cols[c][d] || boxes[b][d]) return false;
                rows[r][d] = cols[c][d] = boxes[b][d] = true;
            }
        return true;
    }

}
