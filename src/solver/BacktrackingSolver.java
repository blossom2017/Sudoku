package solver;

import helper.SudokuUtil;

/** Solves a sudoku puzzle using backtracking algorithm **/
public class BacktrackingSolver {
    int numberOfNodes;
    SudokuUtil sudokuUtil;

    public BacktrackingSolver() {
        numberOfNodes = 0;
        sudokuUtil = new SudokuUtil();
    }

    public static void main(String args[]){
        // Add functionality to parse an input from text file in helper and pass it.
        BacktrackingSolver backtrackingSolver = new BacktrackingSolver();
    }

    private boolean solve(int [][] sudokuBoard) {
        int size = sudokuBoard.length;

        if(this.sudokuUtil.isCompletedSudoku(sudokuBoard)) return true;
        for(int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                if()
            }
        }
    }

    private boolean solveUtil(int [][] sudokuBoard, int count, int size){
        if(count == size*size){
            if(this.sudokuUtil.isCompletedSudoku(sudokuBoard)) return true;
            return false;
        }
        int row = count/size;
        int column = count%size;
        if(sudokuBoard[row][column] == -1) {
            for(int i= 1;i <=size;i++){

            }
        }
    }


}
