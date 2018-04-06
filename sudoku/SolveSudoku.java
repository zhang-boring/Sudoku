package sudoku;

/**
 * This is Description
 *
 * @auther boring
 * @date 2018/04/06
 */
public class SolveSudoku {
    private Sudoku sudoku;
    private int[][] sudokuArray;
    private int LEN = 9;
    private int PALACE = 3;

    public Sudoku getSudoku() {
        return this.sudoku;
    }

    public void setSudoku(Sudoku var1) {
        this.sudoku = var1;
    }

    public SolveSudoku(Sudoku var1) {
        this.sudoku = var1;
        this.sudokuArray = var1.getSudokuArray();
        this.solve();
    }

    public boolean solve() {
        if (!this.haveNext()) {
            return true;
        } else {
            Point var1 = this.next();

            for(int var2 = 1; var2 < this.LEN + 1; ++var2) {
                this.set(var1, var2);

                try {
                    this.print();
                    Thread.sleep(100L);
                } catch (InterruptedException var4) {
                    var4.printStackTrace();
                }

                if (this.check(var1) && this.solve()) {
                    return true;
                }

                this.clear(var1);
            }

            return false;
        }
    }

    private void set(Point var1, int var2) {
        this.sudokuArray[var1.getA()][var1.getB()] = var2;
    }

    private void clear(Point var1) {
        this.sudokuArray[var1.getA()][var1.getB()] = 0;
    }

    public boolean haveNext() {
        return this.next() != null;
    }

    private Point next() {
        for(int var1 = 0; var1 < this.LEN; ++var1) {
            for(int var2 = 0; var2 < this.LEN; ++var2) {
                if (this.sudokuArray[var1][var2] == 0) {
                    return new Point(var1, var2);
                }
            }
        }

        return null;
    }

    public boolean check(Point var1) {
        return this.checkRowsAndColumns(var1) && this.checkPalace(var1);
    }

    private boolean checkRowsAndColumns(Point var1) {
        int var2 = this.sudokuArray[var1.getA()][var1.getB()];

        int var3;
        for(var3 = 0; var3 < this.LEN; ++var3) {
            if (var2 == this.sudokuArray[var1.getA()][var3] && var3 != var1.getB()) {
                return false;
            }
        }

        for(var3 = 0; var3 < this.LEN; ++var3) {
            if (var2 == this.sudokuArray[var3][var1.getB()] && var3 != var1.getA()) {
                return false;
            }
        }

        return true;
    }

    private boolean checkPalace(Point var1) {
        int var2 = this.sudokuArray[var1.getA()][var1.getB()];
        Point var3 = new Point(var1.getA() / 3 * 3, var1.getB() / 3 * 3);

        for(int var4 = 0; var4 < this.PALACE; ++var4) {
            for(int var5 = 0; var5 < this.PALACE; ++var5) {
                if (var2 == this.sudokuArray[var3.getA() + var4][var3.getB() + var5] && var3.getA() + var4 != var1.getA() && var3.getB() + var5 != var1.getB()) {
                    return false;
                }
            }
        }

        return true;
    }

    private void print() {
        for(int var1 = 0; var1 < this.LEN; ++var1) {
            for(int var2 = 0; var2 < this.LEN; ++var2) {
                if (this.sudokuArray[var1][var2] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(this.sudokuArray[var1][var2] + " ");
                }
            }

            System.out.print("\n");
        }

        System.out.print("\n");
    }
}
