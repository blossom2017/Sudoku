package helper;

public class SudokuUtil {
    public boolean isCompletedSudoku(int[][] sudokuGrid) {
        int n = sudokuGrid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sudokuGrid[i][j] == 0) return false;
            }
        }
        return true;
    }

    public boolean isValid(int[][] sudokuGrid, int row, int column, int num) {
        sudokuGrid[row][column] = num;
        return isRowValid(sudokuGrid, row, column, num) &&
                isColumnValid(sudokuGrid, row, column, num) &&
                isSubSquareValid(sudokuGrid, row, column, num);
    }

    public boolean isRowValid(int[][] sudokuGrid, int row, int col, int num) {
        for (int i = 0; i < sudokuGrid.length; i++) {
            if (sudokuGrid[row][i] == num && i != col) {
                return false;
            }
        }
        return true;
    }

    public boolean isColumnValid(int[][] sudokuGrid, int row, int col, int num) {
        for (int i = 0; i < sudokuGrid.length; i++) {
            if (sudokuGrid[i][col] == num && i != row) {
                return false;
            }
        }
        return true;
    }

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

    public void printBoard(int[][] sudokuGrid) {
        int size = sudokuGrid.length;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(sudokuGrid[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
