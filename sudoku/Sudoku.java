package sudoku;

/**
 * This is Description
 *
 * @author boring
 * @date 2018/04/06
 */

public class Sudoku {
    private int[][] sudokuArray;

    public Sudoku(int[][] var1) {
        this.sudokuArray = var1;
    }

    public Sudoku() {
        this.setSudokuArray(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9}, {4, 5, 6, 7, 8, 9, 1, 2, 3}, {7, 8, 9, 1, 2, 3, 4, 5, 6}, {2, 3, 4, 5, 6, 7, 8, 9, 1}, {5, 6, 7, 8, 9, 1, 2, 3, 4}, {8, 9, 1, 2, 3, 4, 5, 6, 7}, {3, 4, 5, 6, 7, 8, 9, 1, 2}, {6, 7, 8, 9, 1, 2, 3, 4, 5}, {9, 1, 2, 3, 4, 5, 6, 7, 8}});
    }

    public int[][] getSudokuArray() {
        return this.sudokuArray;
    }

    public void setSudokuArray(int[][] var1) {
        this.sudokuArray = var1;
    }
}

