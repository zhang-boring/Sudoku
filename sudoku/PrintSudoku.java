package sudoku;

/**
 * This is Description
 *
 * @author boring
 * @date 2018/04/07
 */
public class PrintSudoku {

    private static int LEN = 9;
    private static Sudoku sudoku;
    private static int[][] sudokuArray;

    public static void print(Sudoku sudoku) {
        PrintSudoku.sudoku = sudoku;
        PrintSudoku.sudokuArray = PrintSudoku.sudoku.getSudokuArray();
        for(int i = 0; i < LEN; ++i) {
            for(int j = 0; j < LEN; ++j) {
                if (sudokuArray[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(sudokuArray[i][j] + " ");
                }
            }
            System.out.print("\n");
        }
        System.out.println();
    }
}
