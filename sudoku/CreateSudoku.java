package sudoku;

/**
 * This is Description
 *
 * @author boring
 * @date 2018/04/06
 */
import java.util.Random;

public class CreateSudoku {
    private Sudoku sudoku = new Sudoku();
    private int[][] sudokuArray;
    private Random random;
    private int LEN = 9;
    private int PALACE = 3;
    private int TIME = 10;
    private int a;
    private int b;

    public CreateSudoku() {
        this.sudokuArray = this.sudoku.getSudokuArray();
        this.random = new Random();
    }

    public void changeElements(int a, int b) {
        for(int i = 0; i < LEN; ++i) {
            for(int j = 0; j < LEN; ++j) {
                sudokuArray[i][j] = sudokuArray[i][j] == a ? b :
                        (sudokuArray[i][j] == b ? a : sudokuArray[i][j]);
            }
        }
    }

    public void changeRows(int first, int second) {
        int[] temp = sudokuArray[first];
        sudokuArray[first] = sudokuArray[second];
        sudokuArray[second] = temp;
    }

    public void changeColumns(int first, int second) {
        for(int i = 0; i < LEN; ++i) {
            int temp = sudokuArray[i][first];
            sudokuArray[i][first] = sudokuArray[i][second];
            sudokuArray[i][second] = temp;
        }
    }

    public void changeThreeRows(int first, int second) {
        for(int i = 0; i < PALACE; ++i) {
            changeRows(first + i, second + i);
        }
    }

    public void changeThreeColumns(int first, int second) {
        for(int i = 0; i < PALACE; ++i) {
            changeColumns(first + i, second + i);
        }
    }

    private void setAB1() {
        a = random.nextInt(LEN) + 1;
        b = random.nextInt(LEN) + 1;
    }

    private void setAB2(int palace) {
        a = palace + random.nextInt(PALACE);
        b = palace + random.nextInt(PALACE);
    }

    private void setAB3() {
        a = random.nextInt(PALACE) * PALACE;
        b = random.nextInt(PALACE) * PALACE;
    }

    public Sudoku changeNumbers() {
        for(int i = 0; i < TIME; ++i) {
            setAB1();
            if (a != b) {
                changeElements(a, b);
            } else {
                --i;
            }
        }

        for(int j = 0; j < TIME; ++j) {
            int palace = random.nextInt(PALACE) * PALACE;
            setAB2(palace);
            if (a != b) {
                changeRows(a, b);
            }
            setAB2(palace);
            if (a != b) {
                changeColumns(a, b);
            }
            setAB3();
            if (a != b) {
                changeThreeRows(a, b);
            }
            setAB3();
            if (a != b) {
                changeThreeColumns(a, b);
            }
        }
        sudoku.setSudokuArray(sudokuArray);
        return sudoku;
    }
}
