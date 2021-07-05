package helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileInputUtilTest {
    private FileInputUtil fileInputUtil;

    @BeforeEach
    void setUp() {
        fileInputUtil = new FileInputUtil();
    }

    @Test
    void testReadFile() throws IOException {
        int[][] sudokuBoard = new int[][]{
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
        SudokuUtil sudokuUtil = new SudokuUtil();
        assertTrue(Arrays.deepEquals(fileInputUtil.readFile("/Users/maitrishastri/IdeaProjects/Sudoku/test/java/helper/in1.txt"), sudokuBoard));
    }

    @Test
    void testReadFileThrowsFileNotFoundError() {
        assertThrows(FileNotFoundException.class, () -> {
            fileInputUtil.readFile("/Users/maitrishastri/IdeaProjects/Sudoku/test/java/helper/missingFile.txt");
        });
    }

    @Test
    void testReadFileThrowsInvalidSArgumentExceptionColumnError() {
        assertThrows(IllegalArgumentException.class, () -> {
            fileInputUtil.readFile("/Users/maitrishastri/IdeaProjects/Sudoku/test/java/helper/in2.txt");
        });
    }

    @Test
    void testReadFileThrowsInvalidSArgumentExceptionRowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            fileInputUtil.readFile("/Users/maitrishastri/IdeaProjects/Sudoku/test/java/helper/in3.txt");
        });
    }

    @Test
    void testReadFileThrowsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> {
            fileInputUtil.readFile("/Users/maitrishastri/IdeaProjects/Sudoku/test/java/helper/in4.txt");
        });
    }
}