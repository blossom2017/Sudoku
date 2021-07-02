package solver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BacktrackingSolverTest {
    private BacktrackingSolver backtrackingSolver;

    @BeforeEach
    void setUp() {
        backtrackingSolver = new BacktrackingSolver();
    }

    @Test
    void testSolveGivesCorrectAnswer() {
        int[][] sudokuBoard = {
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
        assertTrue(backtrackingSolver.solve(sudokuBoard));
        assertTrue(Arrays.deepEquals(solvedBoard, sudokuBoard));
    }

    @Test
    void testSolveReturnsFalse() {
        int[][] invalidSudokuBoard = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 1, 0}
        };
        assertFalse(backtrackingSolver.solve(invalidSudokuBoard));
    }

    @Test
    void testSolveThrowsUnsupportedOperationException() {
        int[][] unsupportedBoard = {
                {8, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0},
                {0, 7, 0, 0, 9, 0},
                {0, 5, 0, 0, 0, 7},
                {0, 0, 0, 0, 4, 5},
                {0, 0, 0, 1, 0, 0}
        };
        assertThrows(UnsupportedOperationException.class, () -> {
            backtrackingSolver.solve(unsupportedBoard);
        });
    }
}