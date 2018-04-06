/**
 * This is Description
 *
 * @author boring
 * @date 2018/04/06
 */
import java.util.Scanner;
import sudoku.CreateLevel;
import sudoku.SolveSudoku;
import sudoku.Sudoku;

public class Main {
    private static int LEN = 9;

    public Main() {
    }

    public static void main(String[] var0) {
        System.out.println("请输入难度：\n   1. 简单\n   2. 中等\n   3. 困难");
        Scanner var1 = new Scanner(System.in);
        int var2 = var1.nextInt();
        CreateLevel var3 = new CreateLevel(var2);
        Sudoku var4 = var3.generateGame();
        print(var4);
        SolveSudoku var5 = new SolveSudoku(var4);
        var5.solve();
        print(var5.getSudoku());
    }

    public static void print(Sudoku var0) {
        for(int var1 = 0; var1 < LEN; ++var1) {
            for(int var2 = 0; var2 < LEN; ++var2) {
                if (var0.getSudokuArray()[var1][var2] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(var0.getSudokuArray()[var1][var2] + " ");
                }
            }

            System.out.print("\n");
        }

        System.out.println();
    }
}
