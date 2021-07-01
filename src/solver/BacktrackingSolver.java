package solver;

import helper.SudokuUtil;
import java.lang.IllegalArgumentException;

/**
 * Solves a sudoku puzzle using backtracking algorithm.
 * The unfilled grids are denoted with 0s.
 **/
public class BacktrackingSolver {
    // TODO : Add functionality to measure time.
    int numberOfNodes;
    SudokuUtil sudokuUtil;
    int[][] defaultBoard = {
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
    int[][] sudokuBoard;


    public BacktrackingSolver() {
        numberOfNodes = 0;
        sudokuUtil = new SudokuUtil();
        sudokuBoard = defaultBoard;
    }

    public static void main(String[] args) throws IllegalArgumentException {
        BacktrackingSolver backtrackingSolver = new BacktrackingSolver();
        // TODO(me): Add functionality to parse an input from text file in helper and pass it.
        if (backtrackingSolver.solve(backtrackingSolver.sudokuBoard)) {
            System.out.println("Solved sudoku board =============================");
            backtrackingSolver.sudokuUtil.printBoard(backtrackingSolver.sudokuBoard);
            System.out.print("The number of nodes expanded: " + backtrackingSolver.numberOfNodes);
        } else {
            throw new IllegalArgumentException("The given sudoku board cannot be solved");
        }
    }

    boolean solve(int[][] sudokuBoard) {
        int size = sudokuBoard.length;
        return solveUtil(sudokuBoard, 0, size);
    }

    private boolean solveUtil(int[][] sudokuBoard, int count, int size) {
        if (count == size * size) {
            return this.sudokuUtil.isCompletedSudoku(sudokuBoard);
        }
        numberOfNodes++;
        int row = count / size;
        int column = count % size;
        if (sudokuBoard[row][column] == 0) {
            for (int i = 1; i <= size; i++) {
                if (sudokuUtil.isValid(sudokuBoard, row, column, i)) {
                    sudokuBoard[row][column] = i;
                    if (solveUtil(sudokuBoard, count + 1, size)) return true;
                }
                sudokuBoard[row][column] = 0;
            }
            return false;
        } else return solveUtil(sudokuBoard, count + 1, size);
    }
}
