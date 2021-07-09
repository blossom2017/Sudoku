package helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuUtilTest {
    private SudokuUtil sudokuUtil;
    private int[][] sudokuBoard;

    @BeforeEach
    void setUp() {
        sudokuUtil = new SudokuUtil();
        sudokuBoard = new int[][]{
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };
    }

    @Test
    void testIsCompletedSudokuReturnsTrue() {
        int[][] solvedBoard = {
                {8, 1, 2, 7, 5, 3, 6, 4, 9},
                {9, 4, 3, 6, 8, 2, 1, 7, 5},
                {6, 7, 5, 4, 9, 1, 2, 8, 3},
                {1, 5, 4, 2, 3, 7, 8, 9, 6},
                {3, 6, 9, 8, 4, 5, 7, 2, 1},
                {2, 8, 7, 1, 6, 9, 5, 3, 4},
                {5, 2, 1, 9, 7, 4, 3, 6, 8},
                {4, 3, 8, 5, 2, 6, 9, 1, 7},
                {7, 9, 6, 3, 1, 8, 4, 5, 2}
        };
        assertTrue(sudokuUtil.isCompletedSudoku(solvedBoard));
    }

    @Test
    void testIsCorrectSudokuReturnsTrue() {
        int[][] solvedBoard = {
                {8, 1, 2, 7, 5, 3, 6, 4, 9},
                {9, 4, 3, 6, 8, 2, 1, 7, 5},
                {6, 7, 5, 4, 9, 1, 2, 8, 3},
                {1, 5, 4, 2, 3, 7, 8, 9, 6},
                {3, 6, 9, 8, 4, 5, 7, 2, 1},
                {2, 8, 7, 1, 6, 9, 5, 3, 4},
                {5, 2, 1, 9, 7, 4, 3, 6, 8},
                {4, 3, 8, 5, 2, 6, 9, 1, 7},
                {7, 9, 6, 3, 1, 8, 4, 5, 2}
        };
        assertTrue(sudokuUtil.isCorrectSudoku(solvedBoard));
    }

    @Test
    void testIsCompletedSudokuReturnsFalse() {
        assertFalse(sudokuUtil.isCompletedSudoku(sudokuBoard));
    }

    @Test
    void testIsValidReturnsTrue() {
        assertTrue(sudokuUtil.isValid(sudokuBoard, 0, 1, 1));
    }

    @Test
    void testIsValidReturnsFalse() {
        assertFalse(sudokuUtil.isValid(sudokuBoard, 0, 1, 8));
    }

    @Test
    void isRowValidReturnsTrue() {
        sudokuBoard[0][1] = 1;
        assertTrue(sudokuUtil.isRowValid(sudokuBoard, 0, 1, 1));
    }

    @Test
    void isRowValidReturnsFalse() {
        sudokuBoard[0][1] = 8;
        assertFalse(sudokuUtil.isRowValid(sudokuBoard, 0, 1, 8));
    }

    @Test
    void testIsColumnValidReturnsTrue() {
        sudokuBoard[0][1] = 1;
        assertTrue(sudokuUtil.isColumnValid(sudokuBoard, 0, 1, 1));
    }

    @Test
    void testIsColumnValidReturnsFalse() {
        sudokuBoard[0][1] = 7;
        assertFalse(sudokuUtil.isColumnValid(sudokuBoard, 0, 1, 7));
    }

    @Test
    void testIsSubSquareValidReturnsTrue() {
        sudokuBoard[0][1] = 1;
        assertTrue(sudokuUtil.isSubSquareValid(sudokuBoard, 0, 1, 1));
    }

    @Test
    void testIsSubSquareValidReturnsFalse() {
        sudokuBoard[0][1] = 3;
        assertFalse(sudokuUtil.isSubSquareValid(sudokuBoard, 0, 1, 3));
    }

    @Test
    void testIsPerfectSquareReturnsTrue() {
        assertTrue(sudokuUtil.isPerfectSquare(9));
    }

    @Test
    void testIsPerfectSquareReturnsFalse() {
        assertFalse(sudokuUtil.isPerfectSquare(12));
    }
}