package sudoku;

/**
 * 根据种子数独创建新的最终数独板
 *
 * @author boring
 * @date 2018/04/06
 */
import java.util.Random;

public class CreateSudoku {
    /**
     * 数独对象
     * 数独板
     * 创建随机数
     */
    private Sudoku sudoku = new Sudoku();
    private int[][] sudokuArray;
    private Random random;
    /**
     * 数组大小
     * 九宫格大小
     * 循环打款次数
     */
    private final int LEN = 9;
    private final int PALACE = 3;
    private final int TIME = 10;

    private int a;
    private int b;

    public CreateSudoku() {
        this.sudokuArray = this.sudoku.getSudokuArray();
        this.random = new Random();
    }

    /**
     * 更换任意两数
     *
     * @param a
     * @param b
     */
    private void changeElements(int a, int b) {
        for(int i = 0; i < LEN; ++i) {
            for(int j = 0; j < LEN; ++j) {
                sudokuArray[i][j] = sudokuArray[i][j] == a ? b :
                        (sudokuArray[i][j] == b ? a : sudokuArray[i][j]);
            }
        }
    }

    /**
     * 调换任意两行（九宫内）
     *
     * @param first
     * @param second
     */
    private void changeRows(int first, int second) {
        int[] temp = sudokuArray[first];
        sudokuArray[first] = sudokuArray[second];
        sudokuArray[second] = temp;
    }

    /**
     * 调换任意两列（九宫内）
     *
     * @param first
     * @param second
     */
    private void changeColumns(int first, int second) {
        for(int i = 0; i < LEN; ++i) {
            int temp = sudokuArray[i][first];
            sudokuArray[i][first] = sudokuArray[i][second];
            sudokuArray[i][second] = temp;
        }
    }

    /**
     * 三三列调换（九宫互换）
     *
     * @param first
     * @param second
     */
    private void changeThreeRows(int first, int second) {
        for(int i = 0; i < PALACE; ++i) {
            changeRows(first + i, second + i);
        }
    }

    /**
     * 三三行调换（九宫互换）
     *
     * @param first
     * @param second
     */
    private void changeThreeColumns(int first, int second) {
        for(int i = 0; i < PALACE; ++i) {
            changeColumns(first + i, second + i);
        }
    }

    /**
     * 在[1,9]随机取值，数独板内两数互换
     */
    private void setAB1() {
        a = random.nextInt(LEN) + 1;
        b = random.nextInt(LEN) + 1;
    }

    /**
     * 根据九宫的起始行（列），随机取九宫内两行（列）
     *
     * @param palace
     */
    private void setAB2(int palace) {
        a = palace + random.nextInt(PALACE);
        b = palace + random.nextInt(PALACE);
    }

    /**
     * 随机取数独板内 九宫起始行（列）
     */
    private void setAB3() {
        a = random.nextInt(PALACE) * PALACE;
        b = random.nextInt(PALACE) * PALACE;
    }

    /**
     * 创建数独
     *    1. 互换两数
     *    2. 互换任意九宫内任意两行（列）
     *    3. 三三行（列）互换（0,3,6起始）
     * @return
     */
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
