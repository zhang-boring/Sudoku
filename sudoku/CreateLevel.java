package sudoku;

/**
 * This is Description
 *
 * @author boring
 * @date 2018/04/06
 */
import java.util.Random;

public class CreateLevel {
    private int level;
    private int[] count;
    private int[][] showArray;
    private Sudoku sudoku;
    private int[][] sudokuArray;
    private Random random;
    private final int LEN = 9;
    private final int EASY = 1;
    private final int Medium = 2;
    private final int Hard = 3;

    public CreateLevel(int var1) {
        this.level = var1;
        this.count = new int[9];
        this.sudoku = (new CreateSudoku()).changeNumbers();
        this.sudokuArray = this.sudoku.getSudokuArray();
        this.random = new Random();
        this.showArray = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}};
    }

    private void easyLevel() {
        int var1 = this.random.nextInt(4) + 3;
        this.count[0] = this.count[7] = var1;
        this.count[2] = this.count[6] = 8 - var1;
        int var2 = this.random.nextInt(4) + 4;
        this.count[1] = this.count[4] = var2;
        this.count[5] = this.count[8] = 10 - var2;
        int var3 = this.random.nextInt(4) + 4;
        this.count[3] = var3;

        for(int var4 = 0; var4 < 9; ++var4) {
            this.setShowNumber(var4, this.count[var4]);
        }

    }

    private void mediumLevel() {
        int var1 = this.random.nextInt(3) + 3;
        this.count[0] = this.count[5] = var1;
        this.count[1] = this.count[4] = 7 - this.count[0];
        int var2 = this.random.nextInt(5) + 2;
        this.count[2] = this.count[6] = var2;
        this.count[3] = this.count[8] = 8 - this.count[2];
        int var3 = this.random.nextInt(4) + 1;
        this.count[7] = var3;

        for(int var4 = 0; var4 < 9; ++var4) {
            this.setShowNumber(var4, this.count[var4]);
        }

    }

    private void hardLevel() {
        int var1 = this.random.nextInt(2) + 2;
        this.count[0] = this.count[8] = var1;
        this.count[1] = this.count[7] = 6 - this.count[0];
        int var2 = this.random.nextInt(4) + 1;
        this.count[2] = this.count[6] = var2;
        this.count[3] = this.count[5] = 5 - this.count[2];
        int var3 = this.random.nextInt(4) + 3;
        this.count[4] = var3;

        for(int var4 = 0; var4 < 9; ++var4) {
            this.setShowNumber(var4, this.count[var4]);
        }

    }

    public Sudoku generateGame() {
        switch(this.level) {
            case 1:
                this.easyLevel();
                break;
            case 2:
                this.mediumLevel();
                break;
            case 3:
                this.hardLevel();
                break;
            default:
                this.easyLevel();
        }

        for(int var1 = 0; var1 < 9; ++var1) {
            for(int var2 = 0; var2 < 9; ++var2) {
                if (this.showArray[var1][var2] == 0) {
                    this.sudokuArray[var1][var2] = 0;
                }
            }
        }

        this.sudoku.setSudokuArray(this.sudokuArray);
        return this.sudoku;
    }

    private void setShowNumber(int var1, int var2) {
        int var3 = 0;
        int var4 = this.random.nextInt(9 - var3) + 1;
        int var5 = 0;
        int var6 = 0;

        while(var6 < 9) {
            if (this.showArray[var1][var6] == 0) {
                ++var5;
            }

            if (var5 == var4) {
                this.showArray[var1][var6] = 1;
                ++var3;
                if (var3 == var2) {
                    break;
                }

                var6 = 0;
                var4 = this.random.nextInt(8 - var3) + 1;
                var5 = 0;
            } else {
                ++var6;
            }
        }

    }
}

