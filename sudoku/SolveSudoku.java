package sudoku;

/**
 * 回溯法解决数独题
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

    /**
     * 解决数独，回溯算法
     *
     * @return
     */
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
                } else {
                    clear(point);
                }
            }
            return false;
        }
    }

    /**
     * 设置坐标为point的值为value
     *
     * @param point
     * @param value
     */
    private void set(Point point, int value) {
        sudokuArray[point.getA()][point.getB()] = value;
    }

    /**
     * 擦除坐标为point的值
     *
     * @param point
     */
    private void clear(Point point) {
        sudokuArray[point.getA()][point.getB()] = 0;
    }

    /**
     * 判断数独是否有下一个空缺
     *
     * @return
     */
    private boolean haveNext() {
        return next() != null;
    }

    /**
     *获取下一个空缺坐标
     *
     * @return
     */
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

    /**
     * 检查当前点的值是否合法
     *
     * @param point
     * @return
     */
    private boolean check(Point point) {
        return checkRowsAndColumns(point) && checkPalace(point);
    }

    /**
     * 检查当前点在行、列中是否合法
     *
     * @param point
     * @return
     */
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

    /**
     * 检查当前点在九宫内是否合法
     *
     * @param point
     * @return
     */
    private boolean checkPalace(Point point) {
        int value = sudokuArray[point.getA()][point.getB()];
        //获取当前点所在九宫的起始点
        Point root = new Point(point.getA() / 3 * 3, point.getB() / 3 * 3);

        //遍历九宫并比较
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
