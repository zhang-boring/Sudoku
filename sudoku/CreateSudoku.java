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

    public void changeElements(int var1, int var2) {
        for(int var3 = 0; var3 < this.LEN; ++var3) {
            for(int var4 = 0; var4 < this.LEN; ++var4) {
                this.sudokuArray[var3][var4] = this.sudokuArray[var3][var4] == var1 ? var2 : (this.sudokuArray[var3][var4] == var2 ? var1 : this.sudokuArray[var3][var4]);
            }
        }

    }

    public void changeRows(int var1, int var2) {
        int[] var3 = this.sudokuArray[var1];
        this.sudokuArray[var1] = this.sudokuArray[var2];
        this.sudokuArray[var2] = var3;
    }

    public void changeColumns(int var1, int var2) {
        for(int var4 = 0; var4 < this.LEN; ++var4) {
            int var3 = this.sudokuArray[var4][var1];
            this.sudokuArray[var4][var1] = this.sudokuArray[var4][var2];
            this.sudokuArray[var4][var2] = var3;
        }

    }

    public void changeThreeRows(int var1, int var2) {
        for(int var3 = 0; var3 < this.PALACE; ++var3) {
            this.changeRows(var1 + var3, var2 + var3);
        }

    }

    public void changeThreeColumns(int var1, int var2) {
        for(int var3 = 0; var3 < this.PALACE; ++var3) {
            this.changeColumns(var1 + var3, var2 + var3);
        }

    }

    private void setAB1() {
        this.a = this.random.nextInt(this.LEN) + 1;
        this.b = this.random.nextInt(this.LEN) + 1;
    }

    private void setAB2(int var1) {
        this.a = var1 + this.random.nextInt(this.PALACE);
        this.b = var1 + this.random.nextInt(this.PALACE);
    }

    private void setAB3() {
        this.a = this.random.nextInt(this.PALACE) * this.PALACE;
        this.b = this.random.nextInt(this.PALACE) * this.PALACE;
    }

    public Sudoku changeNumbers() {
        int var1;
        for(var1 = 0; var1 < this.TIME; ++var1) {
            this.setAB1();
            if (this.a != this.b) {
                this.changeElements(this.a, this.b);
            } else {
                --var1;
            }
        }

        for(var1 = 0; var1 < this.TIME; ++var1) {
            int var2 = this.random.nextInt(this.PALACE) * this.PALACE;
            this.setAB2(var2);
            if (this.a != this.b) {
                this.changeRows(this.a, this.b);
            }

            this.setAB2(var2);
            if (this.a != this.b) {
                this.changeColumns(this.a, this.b);
            }

            this.setAB3();
            if (this.a != this.b) {
                this.changeThreeRows(this.a, this.b);
            }

            this.setAB3();
            if (this.a != this.b) {
                this.changeThreeColumns(this.a, this.b);
            }
        }

        this.sudoku.setSudokuArray(this.sudokuArray);
        return this.sudoku;
    }
}
