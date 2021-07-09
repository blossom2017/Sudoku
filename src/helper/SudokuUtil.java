package helper;

import java.util.HashSet;
import java.util.Set;

/**
 * Provides helper methods required to solve a sudoku.
 *
 * @author maitrishastri
 */
public class SudokuUtil {
    /**
     * Returns true if the sudoku grid is completely filled and false otherwise.
     *
     * @param sudokuGrid 2d Array representation of sudoku
     * @return true/false
     */
    public boolean isCompletedSudoku(int[][] sudokuGrid) {
        int n = sudokuGrid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sudokuGrid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns true if the given sudoku satisfies row and column constraints
     *
     * @param sudokuGrid 2d Array representation of sudoku
     * @return true/false
     */
    public boolean isCorrectRowAndColumn(int[][] sudokuGrid) {
        int row = sudokuGrid.length;
        int col = sudokuGrid[0].length;
        for (int i = 0; i < row; i++) {
            HashSet<Integer> str = new HashSet<>();
            HashSet<Integer> stc = new HashSet<>();
            for (int j = 0; j < col; j++) {
                if (stc.contains(sudokuGrid[i][j]))
                    return false;
                stc.add(sudokuGrid[i][j]);
            }
            for (int j = 0; j < col; j++) {
                if (str.contains(sudokuGrid[j][i]))
                    return false;
                str.add(sudokuGrid[j][i]);
            }
        }
        return true;
    }

    /**
     * Returns true if the given sudoku satisfies sub-square constraints
     *
     * @param sudokuGrid 2d Array representation of sudoku
     * @return true/false
     */
    public boolean isCorrectSubSquare(int[][] sudokuGrid) {
        int col = sudokuGrid.length;
        int d = (int) Math.sqrt(col);
        for (int i = 0; i < col; i += d) {
            for (int j = 0; j < col; j += d) {
                HashSet<Integer> st = new HashSet<>();
                for (int k = 0; k < d; k++) {
                    for (int l = 0; l < d; l++) {
                        if (st.contains(sudokuGrid[i + k][j + l])) return false;
                        st.add(sudokuGrid[i + k][j + l]);
                    }
                }
            }
        }
        return true;
    }

    /**
     * Returns true if the given sudoku is complete and correct.
     *
     * @param sudokuGrid
     * @return true/false
     */
    public boolean isCorrectSudoku(int[][] sudokuGrid) {
        int row = sudokuGrid.length;
        if (row == 0) return true;
        int col = sudokuGrid[0].length;
        if (row != col) {
            throw new IllegalArgumentException("The number of rows should be equal to number of columns");
        }
        if (!isPerfectSquare(row)) {
            throw new UnsupportedOperationException("Only perfect square sudoku boards are supported.");
        }
        return isCompletedSudoku(sudokuGrid)
                && isCorrectRowAndColumn(sudokuGrid)
                && isCorrectSubSquare(sudokuGrid);
    }

    /**
     * Returns true if the given move is valid i.e satisfies all row constraints,
     * column constraints and sub-square constraints.
     *
     * @param sudokuGrid 2d Array representation of sudoku
     * @param row        Row number where the number will be filled
     * @param column     Column number where the number will be filled
     * @param num        Number
     * @return True/False
     */
    public boolean isValid(int[][] sudokuGrid, int row, int column, int num) {
        sudokuGrid[row][column] = num;
        return isRowValid(sudokuGrid, row, column, num) &&
                isColumnValid(sudokuGrid, row, column, num) &&
                isSubSquareValid(sudokuGrid, row, column, num);
    }

    /**
     * Returns true if the given move satisfies row constraint.
     *
     * @param sudokuGrid 2d Array representation of sudoku
     * @param row        Row number where the number will be filled
     * @param col        Column number where the number will be filled
     * @param num        Number
     * @return True/False
     */
    public boolean isRowValid(int[][] sudokuGrid, int row, int col, int num) {
        for (int i = 0; i < sudokuGrid.length; i++) {
            if (sudokuGrid[row][i] == num && i != col) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the given move satisfies column constraint.
     *
     * @param sudokuGrid 2d Array representation of sudoku
     * @param row        Row number where the number will be filled
     * @param col        Column number where the number will be filled
     * @param num        Number
     * @return True/False
     */
    public boolean isColumnValid(int[][] sudokuGrid, int row, int col, int num) {
        for (int i = 0; i < sudokuGrid.length; i++) {
            if (sudokuGrid[i][col] == num && i != row) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the given move satisfies sub-square constraint.
     *
     * @param sudokuGrid 2d Array representation of sudoku
     * @param row        Row number where the number will be filled
     * @param col        Column number where the number will be filled
     * @param num        Number
     * @return True/False
     */
    public boolean isSubSquareValid(int[][] sudokuGrid, int row, int col, int num) {
        int n = (int) Math.sqrt(sudokuGrid.length);
        int startRow = (row / n) * n;
        int startCol = (col / n) * n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sudokuGrid[i + startRow][j + startCol] == sudokuGrid[row][col] &&
                        (i + startRow != row || j + startCol != col))
                    return false;
            }
        }
        return true;
    }

    /**
     * Utility to print the board
     *
     * @param sudokuGrid 2d Array representation of sudoku
     */
    public void printBoard(int[][] sudokuGrid) {
        int size = sudokuGrid.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(sudokuGrid[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Returns true if the number is perfect square.
     *
     * @param num Size of the sudoku board
     * @return True/False
     */
    public boolean isPerfectSquare(int num) {
        return (Math.sqrt(num) - Math.floor(Math.sqrt(num)) == 0);
    }
}
