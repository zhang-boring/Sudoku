package sudoku;

/**
 * 创建不同难度数独题
 *
 * @author boring
 * @date 2018/04/06
 */
import java.util.Random;

public class CreateLevel {
    private Sudoku sudoku;
    /**
     * 难度等级
     * 每行显示的数字的个数
     * 标记相应位置数字是否显示
     */
    private int level;
    private int[] count;
    private int[][] showArray;

    /**
     * 数独板
     * 获取随机数
     * 数组大小
     */
    private int[][] sudokuArray;
    private Random random;
    private final int LEN = 9;

    /**
     * 难度等级
     */
    private final int EASY = 1;
    private final int Medium = 2;
    private final int Hard = 3;

    public CreateLevel(int level) {
        this.level = level;
        this.count = new int[9];
        this.sudoku = (new CreateSudoku()).changeNumbers();
        this.sudokuArray = this.sudoku.getSudokuArray();
        this.random = new Random();
        this.showArray = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    }

    /**
     * 设置相应行显示数字个数
     * 当前位置值为0则表示不显示该位置数字
     *
     * @param row
     * @param num
     */
    private void setShowNumber(int row, int num) {
        int show = 0;
        int a = random.nextInt(9 - show) + 1;
        int temp = 0;
        int i = 0;

        /*
        a为随机获取的位置，
        遍历该行，遇到0向后移且temp++，遇到1向后移，
        当temp==a，设置当前位置为1，标记为显示，i、temp置0，a重新随机
        重复num次
         */
        while(i < LEN) {
            if (showArray[row][i] == 0) {
                ++temp;
            }
            if (temp == a) {
                showArray[row][i] = 1;
                ++show;
                if (show == num) {
                    break;
                } else {
                    i = 0;
                    a = random.nextInt(8 - show) + 1;
                    temp = 0;
                }
            } else {
                ++i;
            }
        }

    }

    /**
     * 简单难度
     * 已知40-43个数
     * a*2+(8-a)*2 + b*2+(10-b)*2 + c
     */
    private void easyLevel() {
        int a = random.nextInt(4) + 3;
        count[0] = count[7] = a;
        count[2] = count[6] = 8 - a;
        int b = random.nextInt(4) + 4;
        count[1] = count[4] = b;
        count[5] = count[8] = 10 - b;
        int c = random.nextInt(4) + 4;
        count[3] = c;

        for(int i = 0; i < LEN; ++i) {
            setShowNumber(i, count[i]);
        }

    }

    /**
     * 中等难度
     * 已知31-34个数
     * a*2+(7-a)*2 + b*2+(8-b)*2 + c
     */
    private void mediumLevel() {
        int a = random.nextInt(3) + 3;
        count[0] = count[5] = a;
        count[1] = count[4] = 7 - count[0];
        int b = random.nextInt(5) + 2;
        count[2] = count[6] = b;
        count[3] = count[8] = 8 - count[2];
        int c = random.nextInt(4) + 1;
        count[7] = c;

        for(int i = 0; i < LEN; ++i) {
            setShowNumber(i, count[i]);
        }

    }

    /**
     * 困难难度
     * 已知25-28个数
     * a*2+(6-a)*2 + b*2+(5-b)*2 + c
     */
    private void hardLevel() {
        int a = this.random.nextInt(2) + 2;
        count[0] = count[8] = a;
        count[1] = count[7] = 6 - count[0];
        int b = random.nextInt(4) + 1;
        count[2] = count[6] = b;
        count[3] = count[5] = 5 - count[2];
        int c = random.nextInt(4) + 3;
        count[4] = c;

        for(int i = 0; i < LEN; ++i) {
            setShowNumber(i, count[i]);
        }

    }

    /**
     * 根据showArray[][]生成数独游戏
     *
     * @return
     */
    public Sudoku generateGame() {
        switch(level) {
            case EASY:
                easyLevel();
                break;
            case Medium:
                mediumLevel();
                break;
            case Hard:
                hardLevel();
                break;
            default:
                easyLevel();
        }

        for(int i = 0; i < LEN; ++i) {
            for(int j = 0; j < LEN; ++j) {
                if (showArray[i][j] == 0) {
                    sudokuArray[i][j] = 0;
                }
            }
        }

        sudoku.setSudokuArray(sudokuArray);
        return sudoku;
    }


}

