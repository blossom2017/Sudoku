package helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.IllegalArgumentException;

/**
 * Provides helper methods to create sudoku input from a text file
 *
 * @author maitrishastri
 */
public class FileInputUtil {
    private SudokuUtil sudokuUtil = new SudokuUtil();

    private int[][] readFile(String filename) throws IllegalArgumentException {
        BufferedReader bf;
        int[][] sudokuBoard;

        try {
            bf = new BufferedReader(new FileReader(filename));
            try {
                int numberOfLines = Integer.valueOf(bf.readLine());
                if (!sudokuUtil.isPerfectSquare(numberOfLines)) {
                    throw new UnsupportedOperationException("Only perfect square sudoku boards are supported.");
                }
                sudokuBoard = new int[numberOfLines][numberOfLines];
                for (int i = 0; i < numberOfLines; i++) {
                    //split by spaces into an array of numbers.
                    String temp[] = bf.readLine().split("\\s+");
                    if (temp.length != numberOfLines) {
                        throw new IllegalArgumentException("The sudoku given is invalid as the number of rows don't match the number of columns.");
                    }
                    for (int j = 0; j < temp.length; j++) {
                        sudokuBoard[i][j] = Integer.valueOf(temp[j]);
                    }
                }
                return sudokuBoard;
            } catch (IOException e) {
                System.out.println("Cannot read file " + filename);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file " + filename);
        }
        return null;
    }
}
