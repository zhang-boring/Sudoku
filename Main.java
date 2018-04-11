/**
 * 测试
 *
 * @author boring
 * @date 2018/04/06
 */
import java.util.Scanner;
import sudoku.CreateLevel;
import sudoku.PrintSudoku;
import sudoku.SolveSudoku;
import sudoku.Sudoku;

public class Main {
    private static int LEN = 9;

    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("请输入难度：\n   1. 简单\n   2. 中等\n   3. 困难");
        Scanner scanner = new Scanner(System.in);
        int level = scanner.nextInt();
        CreateLevel createLevel = new CreateLevel(level);
        SolveSudoku solveSudoku = new SolveSudoku(createLevel.generateGame());
        solveSudoku.solve();
    }
}
