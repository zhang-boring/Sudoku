package sudoku;

/**
 * This is Description
 *
 * @author boring
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

    public void setSudoku(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    public SolveSudoku(Sudoku sudoku) {
        this.sudoku = sudoku;
        this.sudokuArray = sudoku.getSudokuArray();
        this.solve();
    }

    public boolean solve() {
        if (!haveNext()) {
            return true;
        } else {
            Point point = next();

            for(int i = 1; i < LEN + 1; ++i) {
                set(point, i);

                try {
                    PrintSudoku.print(sudoku);
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (check(point) && solve()) {
                    return true;
                }

                clear(point);
            }

            return false;
        }
    }

    private void set(Point point, int value) {
        sudokuArray[point.getA()][point.getB()] = value;
    }

    private void clear(Point point) {
        sudokuArray[point.getA()][point.getB()] = 0;
    }

    public boolean haveNext() {
        return next() != null;
    }

    private Point next() {
        for(int i = 0; i < LEN; ++i) {
            for(int j = 0; j < LEN; ++j) {
                if (sudokuArray[i][j] == 0) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    public boolean check(Point point) {
        return checkRowsAndColumns(point) && checkPalace(point);
    }

    private boolean checkRowsAndColumns(Point point) {
        int value = sudokuArray[point.getA()][point.getB()];

        for(int i = 0; i < LEN; ++i) {
            if (value == sudokuArray[point.getA()][i] && i != point.getB()) {
                return false;
            }
        }

        for(int j = 0; j < LEN; ++j) {
            if (value == sudokuArray[j][point.getB()] && j != point.getA()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkPalace(Point point) {
        int value = sudokuArray[point.getA()][point.getB()];
        Point root = new Point(point.getA() / 3 * 3, point.getB() / 3 * 3);

        for(int i = 0; i < PALACE; ++i) {
            for(int j = 0; j < PALACE; ++j) {
                if (value == sudokuArray[root.getA() + i][root.getB() + j] &&
                        root.getA() + i != point.getA() &&
                        root.getB() + j != point.getB()) {
                    return false;
                }
            }
        }

        return true;
    }
}
