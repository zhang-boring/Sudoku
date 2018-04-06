package sudoku;

/**
 * This is Description
 *
 * @author boring
 * @date 2018/04/06
 */

public class Sudoku {
    private int[][] sudokuArray;

    public Sudoku(int[][] sudokuArray) {
        this.sudokuArray = sudokuArray;
    }

    public Sudoku() {
        this.setSudokuArray(new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}
        });
    }

    public int[][] getSudokuArray() {
        return sudokuArray;
    }

    public void setSudokuArray(int[][] sudokuArray) {
        this.sudokuArray = sudokuArray;
    }
}

